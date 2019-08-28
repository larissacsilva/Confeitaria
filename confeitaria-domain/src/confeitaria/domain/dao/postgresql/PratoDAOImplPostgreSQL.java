package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IPratoDAO;
import confeitaria.domain.entidades.Prato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PratoDAOImplPostgreSQL implements IPratoDAO{

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

    public void cadastrar(Prato ent){
        Connection con = criaConexao();
        
        String sql = "Insert into prato (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Prato ent){
        Connection con = criaConexao();
        String sql = "update prato set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_prato());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM prato where prato.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Prato> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Prato> lista = new ArrayList<>();
        String sql = "select * from prato";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Prato c = new Prato();
            c.setId_prato(res.getInt("id"));
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
