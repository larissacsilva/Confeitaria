package controller;

import confeitaria.domain.dao.IClienteDAO;
import confeitaria.domain.dao.list.ClienteDAOImpl;
import confeitaria.domain.dao.postgresql.ClienteDAOImplPostgreSQL;
import confeitaria.domain.entidades.Cliente;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/cliente")

public class ClienteController {
    private IClienteDAO banco = new ClienteDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Cliente cliente : banco.consultar()){
            if(cliente.getCpf() == pk){
                return cliente;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
        Cliente novo = new Cliente();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}