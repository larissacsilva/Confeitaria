package controller;

import confeitaria.domain.dao.IFuncionarioDAO;
import confeitaria.domain.dao.list.FuncionarioDAOImpl;
import confeitaria.domain.dao.postgresql.FuncionarioDAOImplPostgreSQL;
import confeitaria.domain.entidades.Funcionario;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/funcionario")

public class FuncionarioController {
    private IFuncionarioDAO banco = new FuncionarioDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Funcionario func : banco.consultar()){
            if(func.getCpf() == pk){
                return func;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
        Funcionario novo = new Funcionario();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}