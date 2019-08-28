package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IFornecedorDAO;
import confeitaria.domain.entidades.Fornecedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FornecedorDAOImplPostgreSQL implements IFornecedorDAO{

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

    public void cadastrar(Fornecedor ent){
        Connection con = criaConexao();
        
        String sql = "Insert into fornecedor (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Fornecedor ent){
        Connection con = criaConexao();
        String sql = "update fornecedor set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getId_fornecedor());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM fornecedor where fornecedor.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Fornecedor> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "select * from fornecedor";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Fornecedor c = new Fornecedor();
            c.setId_fornecedor(res.getInt("id"));
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
