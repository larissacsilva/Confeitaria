
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Caixa;
import java.util.List;

public interface ICaixaDAO {
    public void abrir(Caixa ent);
    
    public void fechar(Caixa ent);
    
    public List<Caixa> consultar();
}
