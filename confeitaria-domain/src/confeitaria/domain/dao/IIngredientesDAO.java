package confeitaria.domain.dao;

import confeitaria.domain.entidades.Ingredientes;
import java.util.List;

public interface IIngredientesDAO {
    public void cadastrar(Ingredientes ent);
    
    public void alterar(Ingredientes ent);
    
    public void excluir(int id);
    
    public List<Ingredientes> consultar();
}
