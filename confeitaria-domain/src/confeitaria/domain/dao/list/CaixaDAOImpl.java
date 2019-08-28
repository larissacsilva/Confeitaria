package confeitaria.domain.dao.list;

import confeitaria.domain.dao.ICaixaDAO;
import confeitaria.domain.entidades.Caixa;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAOImpl implements ICaixaDAO{
    
    private static List<Caixa> caixa = new ArrayList<>();
    private static int lastId = 1;

    public void cadastrar(Caixa ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(caixa.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_caixa(lastId);
        lastId++;
        caixa.add(ent);
    }

    public void alterar(Caixa ent) {
        for (int i = 0; i < caixa.size(); i++) {
            Caixa get = caixa.get(i);
            if(ent.getId_caixa() == get.getId_caixa()){
                if(!caixa.contains(ent)){
                    caixa.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < caixa.size(); i++) {
            Caixa get = caixa.get(i);
            if(get.getId_caixa() == id){
                caixa.remove(i);
                break;
            }
        }
    }

    public List<Caixa> consultar() {
        return caixa;
    }

       
}
