package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.ICaixaDAO;
import confeitaria.domain.entidades.Caixa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CaixaDAOImplPostgreSQL implements ICaixaDAO{

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

    public void cadastrar(Caixa ent){
        Connection con = criaConexao();
        
        String sql = "Insert into caixa (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Caixa ent){
        Connection con = criaConexao();
        String sql = "update caixa set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_caixa());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM caixa where caixa.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Caixa> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Caixa> lista = new ArrayList<>();
        String sql = "select * from caixa";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Caixa c = new Caixa();
            c.setId_caixa(res.getInt("id"));
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
