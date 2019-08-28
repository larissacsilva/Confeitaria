package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IClienteDAO;
import confeitaria.domain.entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAOImplPostgreSQL implements IClienteDAO{

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

    public void cadastrar(Cliente ent){
        Connection con = criaConexao();
       
        String sql = "Insert into cliente (cpf,nome,fone,endereco)"
                + " Values('"+ent.getCpf()+","+ent.getNome()+","+ent.getFone()+","+ent.getEndereco()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Cliente ent){
        Connection con = criaConexao();
        String sql = "update cliente set "
                + "nome = ? where id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ent.getNome());
            ps.setInt(2, ent.getCpf());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void excluir(int id) {
        Connection con = criaConexao();
        
        String sql = "DELETE FROM cliente where cliente.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Cliente> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Cliente> lista = new ArrayList<>();
        String sql = "select * from cliente";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Cliente c = new Cliente();
            c.setCpf(res.getInt("id"));
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
