package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IItemPedidoDAO;
import confeitaria.domain.entidades.ItemPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ItemPedidoDAOImplPostgreSQL implements IItemPedidoDAO{

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

    public void cadastrar(ItemPedido ent){
        Connection con = criaConexao();
        
        String sql = "Insert into itempedido (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(ItemPedido ent){
        Connection con = criaConexao();
        String sql = "update itempedido set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_item());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM itempedido where itempedido.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<ItemPedido> consultar() {
       Connection con = criaConexao();
        
        try{
        List<ItemPedido> lista = new ArrayList<>();
        String sql = "select * from itempedido";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            ItemPedido c = new ItemPedido();
            c.setId_item(res.getInt("id"));
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
