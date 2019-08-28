package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IItemPedidoDAO;
import confeitaria.domain.entidades.ItemPedido;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAOImpl implements IItemPedidoDAO{
    
    private static List<ItemPedido> itens_pedido = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(ItemPedido ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(itens_pedido.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_item(lastId);
        lastId++;
        itens_pedido.add(ent);
    }

    public void alterar(ItemPedido ent) {
        for (int i = 0; i < itens_pedido.size(); i++) {
            ItemPedido get = itens_pedido.get(i);
            if(ent.getId_item() == get.getId_item()){
                if(!itens_pedido.contains(ent)){
                    itens_pedido.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < itens_pedido.size(); i++) {
            ItemPedido get = itens_pedido.get(i);
            if(get.getId_item() == id){
                itens_pedido.remove(i);
                break;
            }
        }
    }

    public List<ItemPedido> consultar() {
        return itens_pedido;
    }



    
}
