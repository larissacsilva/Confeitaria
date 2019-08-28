package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IIngredienteDAO;
import confeitaria.domain.entidades.Ingrediente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class IngredienteDAOImplPostgreSQL implements IIngredienteDAO{

    private Connection criaConexao(){
        Connection conexao = null;
        try{
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/confeitaria","postgres","postgres");
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return conexao;
    }

    public void cadastrar(Ingrediente ent){
        Connection con = criaConexao();
        
        String sql = "Insert into ingrediente (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Ingrediente ent){
        Connection con = criaConexao();
        String sql = "update ingrediente set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_ingrediente());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM ingrediente where ingrediente.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Ingrediente> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "select * from ingrediente";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Ingrediente c = new Ingrediente();
            c.setId_ingrediente(res.getInt("id"));
            c.setNome(res.getString("nome"));
            lista.add(c);
            
        }
        
        return lista;
        }catch(Exception erro){
            erro.printStackTrace();
            }
        return null;
    }


    
}
