package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IFornecedorDAO;
import confeitaria.domain.entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAOImpl implements IFornecedorDAO{
    
    private static List<Fornecedor> fornecedores = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(Fornecedor ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(fornecedores.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_fornecedor(lastId);
        lastId++;
        fornecedores.add(ent);
    }

    public void alterar(Fornecedor ent) {
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor get = fornecedores.get(i);
            if(ent.getId_fornecedor() == get.getId_fornecedor()){
                if(!fornecedores.contains(ent)){
                    fornecedores.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor get = fornecedores.get(i);
            if(get.getId_fornecedor() == id){
                fornecedores.remove(i);
                break;
            }
        }
    }

    public List<Fornecedor> consultar() {
        return fornecedores;
    }



    
}
