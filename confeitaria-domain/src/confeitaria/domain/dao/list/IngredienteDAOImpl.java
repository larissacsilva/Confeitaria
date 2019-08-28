package confeitaria.domain.dao.list;

import confeitaria.domain.dao.IIngredienteDAO;
import confeitaria.domain.entidades.Ingrediente;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAOImpl implements IIngredienteDAO{
    
    private static List<Ingrediente> ingredientes = new ArrayList<>();
    private static int lastId = 1;


    public void cadastrar(Ingrediente ent) {
        if(ent == null){
            throw new NullPointerException();
        }
        if(ingredientes.contains(ent)){
            throw new RuntimeException("Valor repetido!");
        }
        ent.setId_ingrediente(lastId);
        lastId++;
        ingredientes.add(ent);
    }

    public void alterar(Ingrediente ent) {
        for (int i = 0; i < ingredientes.size(); i++) {
            Ingrediente get = ingredientes.get(i);
            if(ent.getId_ingrediente() == get.getId_ingrediente()){
                if(!ingredientes.contains(ent)){
                    ingredientes.set(i, ent);
                }
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < ingredientes.size(); i++) {
            Ingrediente get = ingredientes.get(i);
            if(get.getId_ingrediente() == id){
                ingredientes.remove(i);
                break;
            }
        }
    }

   public List<Ingrediente> consultar(){    
       return ingredientes;
   }
}
