package controller;

import confeitaria.domain.dao.IIngredienteDAO;
import confeitaria.domain.dao.list.IngredienteDAOImpl;
import confeitaria.domain.dao.postgresql.IngredienteDAOImplPostgreSQL;
import confeitaria.domain.entidades.Ingrediente;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/ingrediente")

public class IngredienteController {
    private IIngredienteDAO banco = new IngredienteDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ingrediente> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ingrediente select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Ingrediente ing : banco.consultar()){
            if(ing.getId_ingrediente() == pk){
                return ing;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
            Ingrediente novo = new Ingrediente();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}