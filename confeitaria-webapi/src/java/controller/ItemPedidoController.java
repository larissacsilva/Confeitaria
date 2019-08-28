package controller;

import confeitaria.domain.dao.IItemPedidoDAO;
import confeitaria.domain.dao.list.ItemPedidoDAOImpl;
import confeitaria.domain.dao.postgresql.ItemPedidoDAOImplPostgreSQL;
import confeitaria.domain.entidades.ItemPedido;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/itempedido")

public class ItemPedidoController {
    private IItemPedidoDAO banco = new ItemPedidoDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemPedido> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemPedido select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(ItemPedido item : banco.consultar()){
            if(item.getId_item() == pk){
                return item;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
            ItemPedido novo = new ItemPedido();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}