package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IClienteDAO;
import confeitaria.domain.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements IClienteDAO{
    
    private static List<Cliente> clientes = new ArrayList<>();
    private static int lastId = 1;

    public void cadastrar(Cliente ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(clientes.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setCpf(lastId);
        lastId++;
        clientes.add(ent);
    }

    public void alterar(Cliente ent) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            if(ent.getCpf() == get.getCpf()){
                if(!clientes.contains(ent)){
                    clientes.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente get = clientes.get(i);
            if(get.getCpf() == id){
                clientes.remove(i);
                break;
            }
        }
    }

    public List<Cliente> consultar() {
        return clientes;
    }

       
}
