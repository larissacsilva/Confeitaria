
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Fornecedor;
import java.util.List;

public interface IFornecedorDAO {
    public void cadastrar(Fornecedor ent);
    
    public void alterar(Fornecedor ent);
    
    public void excluir(int cpf);
    
    public List<Fornecedor> consultar();
}
