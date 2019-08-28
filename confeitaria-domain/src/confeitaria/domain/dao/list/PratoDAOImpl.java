package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IPratoDAO;
import confeitaria.domain.entidades.Prato;
import java.util.ArrayList;
import java.util.List;

public class PratoDAOImpl implements IPratoDAO{
    
    private static List<Prato> pratos = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(Prato ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(pratos.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_prato(lastId);
        lastId++;
        pratos.add(ent);
    }

    public void alterar(Prato ent) {
        for (int i = 0; i < pratos.size(); i++) {
            Prato get = pratos.get(i);
            if(ent.getId_prato() == get.getId_prato()){
                if(!pratos.contains(ent)){
                    pratos.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < pratos.size(); i++) {
            Prato get = pratos.get(i);
            if(get.getId_prato() == id){
                pratos.remove(i);
                break;
            }
        }
    }

    public List<Prato> consultar() {
        return pratos;
    }



    
}
