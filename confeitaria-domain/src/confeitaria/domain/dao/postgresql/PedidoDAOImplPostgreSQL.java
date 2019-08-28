package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IPedidoDAO;
import confeitaria.domain.entidades.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAOImplPostgreSQL implements IPedidoDAO{

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

    public void cadastrar(Pedido ent){
        Connection con = criaConexao();
        
        String sql = "Insert into pedido (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Pedido ent){
        Connection con = criaConexao();
        String sql = "update pedido set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_pedido());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM pedido where pedido.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Pedido> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Pedido> lista = new ArrayList<>();
        String sql = "select * from pedido";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Pedido c = new Pedido();
            c.setId_pedido(res.getInt("id"));
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
