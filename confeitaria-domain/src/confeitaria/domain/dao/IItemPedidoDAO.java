package confeitaria.domain.dao;

import confeitaria.domain.entidades.ItemPedido;
import java.util.List;

public interface IItemPedidoDAO {
    public void cadastrar(ItemPedido ent);
    
    public void alterar(ItemPedido ent);
    
    public void excluir(int id);
    
    public List<ItemPedido> consultar();
}
