package controller;

import confeitaria.domain.dao.IPratoDAO;
import confeitaria.domain.dao.list.PratoDAOImpl;
import confeitaria.domain.dao.postgresql.PratoDAOImplPostgreSQL;
import confeitaria.domain.entidades.Prato;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/prato")

public class PratoController {
    private IPratoDAO banco = new PratoDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prato> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prato select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Prato prato : banco.consultar()){
            if(prato.getId_prato() == pk){
                return prato;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
            Prato novo = new Prato();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}