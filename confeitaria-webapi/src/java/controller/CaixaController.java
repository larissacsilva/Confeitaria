
package controller;


import confeitaria.domain.dao.ICaixaDAO;
import confeitaria.domain.dao.list.CaixaDAOImpl;
import confeitaria.domain.dao.postgresql.CaixaDAOImplPostgreSQL;
import confeitaria.domain.entidades.Caixa;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * REST Web Service
 *
 * @author larissa
 */
@Path("/caixa")

public class CaixaController {
    private ICaixaDAO banco = new CaixaDAOImplPostgreSQL();
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Caixa> index(){
        return banco.consultar();
    }

    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Caixa select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        for(Caixa caixa : banco.consultar()){
            if(caixa.getId_caixa() == pk){
                return caixa;
                }
            }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cadastrar/{nome}")
    public String cadastrar(@PathParam("nome") String nome){
        Caixa novo = new Caixa();
        novo.setNome(nome);
        banco.cadastrar(novo);
        String ret = "{\"status\": 1}";   
        return ret;
        }
}
