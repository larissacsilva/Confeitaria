
package confeitaria.domain.dao;

import confeitaria.domain.entidades.Caixa;
import java.util.List;

public interface ICaixaDAO {
   public void cadastrar(Caixa ent);
    
    public void alterar(Caixa ent);
    
    public void excluir(int id_caixa);
    
    public List<Caixa> consultar();
}
