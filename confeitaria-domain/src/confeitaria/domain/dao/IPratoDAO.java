
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Prato;
import java.util.List;

public interface IPratoDAO {
    public void cadastrar(Prato ent);
    
    public void alterar(Prato ent);
    
    public void excluir(int id);
    
    public List<Prato> consultar();
}
