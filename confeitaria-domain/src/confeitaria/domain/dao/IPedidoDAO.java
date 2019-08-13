
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Pedido;
import java.util.List;

public interface IPedidoDAO {
    public void cadastrar(Pedido ent);
    
    public void alterar(Pedido ent);
    
    public void excluir(int id);
    
    public List<Pedido> consultar();
}
