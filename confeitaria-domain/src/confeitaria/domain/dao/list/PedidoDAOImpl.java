package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IPedidoDAO;
import confeitaria.domain.entidades.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements IPedidoDAO{
    
    private static List<Pedido> pedido = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(Pedido ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(pedido.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_pedido(lastId);
        lastId++;
        pedido.add(ent);
    }

    public void alterar(Pedido ent) {
        for (int i = 0; i < pedido.size(); i++) {
            Pedido get = pedido.get(i);
            if(ent.getId_pedido() == get.getId_pedido()){
                if(!pedido.contains(ent)){
                    pedido.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < pedido.size(); i++) {
            Pedido get = pedido.get(i);
            if(get.getId_pedido() == id){
                pedido.remove(i);
                break;
            }
        }
    }

    public List<Pedido> consultar() {
        return pedido;
    }

    
}
