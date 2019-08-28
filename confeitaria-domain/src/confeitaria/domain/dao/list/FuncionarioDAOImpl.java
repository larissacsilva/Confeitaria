package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IFuncionarioDAO;
import confeitaria.domain.entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl implements IFuncionarioDAO{
    
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(Funcionario ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(funcionarios.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setCpf(lastId);
        lastId++;
        funcionarios.add(ent);
    }

    public void alterar(Funcionario ent) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario get = funcionarios.get(i);
            if(ent.getCpf() == get.getCpf()){
                if(!funcionarios.contains(ent)){
                    funcionarios.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario get = funcionarios.get(i);
            if(get.getCpf() == id){
                funcionarios.remove(i);
                break;
            }
        }
    }

    public List<Funcionario> consultar() {
        return funcionarios;
    }


    
}
