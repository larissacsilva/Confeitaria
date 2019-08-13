
package confeitaria.domain.entidades;

public class PedidoIngredientes {
    private int id_pedido_ing;
    private int quant;
    private float valor;

    public int getId_pedido_ing() {
        return id_pedido_ing;
    }

    public void setId_pedido_ing(int id_pedido_ing) {
        this.id_pedido_ing = id_pedido_ing;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
