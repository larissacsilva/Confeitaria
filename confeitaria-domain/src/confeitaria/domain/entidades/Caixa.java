
package confeitaria.domain.entidades;

public class Caixa {
    private int id_caixa;
    private String nome;
    private float saldo_inicial;
    private float saldo_final;
    private String hora_inicial;
    private String hora_final;
    private boolean status;
    private String forma_pagamento;

    public int getId_caixa() {
        return id_caixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public float getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(float saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public float getSaldo_final() {
        return saldo_final;
    }

    public void setSaldo_final(float saldo_final) {
        this.saldo_final = saldo_final;
    }

    public String getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(String hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }
    
    
}
