package controller;

import confeitaria.domain.dao.IPedidoDAO;
import confeitaria.domain.dao.list.PedidoDAOImpl;
import confeitaria.domain.dao.postgresql.PedidoDAOImplPostgreSQL;
import confeitaria.domain.entidades.Pedido;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/pedido")

public class PedidoController {
    private IPedidoDAO banco = new PedidoDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Pedido item : banco.consultar()){
            if(item.getId_pedido() == pk){
                return item;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
            Pedido novo = new Pedido();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}