package confeitaria.domain.dao.postgresql;

import confeitaria.domain.dao.IFuncionarioDAO;
import confeitaria.domain.entidades.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAOImplPostgreSQL implements IFuncionarioDAO{

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

    public void cadastrar(Funcionario ent){
        Connection con = criaConexao();
        
        String sql = "Insert into funcionario (nome)"
                + " Values('"+ent.getNome()+"')";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
     }
    

    public void alterar(Funcionario ent){
        Connection con = criaConexao();
        String sql = "update funcionario set "
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
        
        String sql = "DELETE FROM funcionario where funcionario.id = "
                + "'"+id+"'";
        try{
        con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
            }
    }

    @Override
    public List<Funcionario> consultar() {
       Connection con = criaConexao();
        
        try{
        List<Funcionario> lista = new ArrayList<>();
        String sql = "select * from funcionario";
        
        ResultSet res = con.createStatement().executeQuery(sql);
        while(res.next()){
            Funcionario c = new Funcionario();
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
