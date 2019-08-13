
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Cliente;
import java.util.List;

public interface IClienteDAO {
    public void cadastrar(Cliente ent);
    
    public void alterar(Cliente ent);
    
    public void excluir(int cpf);
    
    public List<Cliente> consultar();
}
