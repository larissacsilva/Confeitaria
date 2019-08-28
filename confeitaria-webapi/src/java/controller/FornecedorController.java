package controller;

import confeitaria.domain.dao.IFornecedorDAO;
import confeitaria.domain.dao.list.FornecedorDAOImpl;
import confeitaria.domain.dao.postgresql.FornecedorDAOImplPostgreSQL;
import confeitaria.domain.entidades.Fornecedor;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/fornecedor")

public class FornecedorController {
    private IFornecedorDAO banco = new FornecedorDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fornecedor select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Fornecedor forn : banco.consultar()){
            if(forn.getId_fornecedor() == pk){
                return forn;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
        Fornecedor novo = new Fornecedor();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}