
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Funcionario;
import java.util.List;

public interface IFuncionarioDAO {
        public void cadastrar(Funcionario ent);
    
    public void alterar(Funcionario ent);
    
    public void excluir(int cpf);
    
    public List<Funcionario> consultar();
}
