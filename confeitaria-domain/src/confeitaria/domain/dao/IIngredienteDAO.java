package confeitaria.domain.dao;

import confeitaria.domain.entidades.Ingrediente;
import java.util.List;

public interface IIngredienteDAO {
    public void cadastrar(Ingrediente ent);
    
    public void alterar(Ingrediente ent);
    
    public void excluir(int id);
    
    public List<Ingrediente> consultar();
}
