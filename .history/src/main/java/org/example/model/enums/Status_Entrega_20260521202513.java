package org.example.model.enums;

public class Status_Entrega {
    
    PENDENTE(1, "PENDENTE"),
    ENTREGUE(2, "ENTREGUE"),
    CANCELADO(3, "CANCELADO");

    private int codigo;
    private String descricao;

    private Status_Pedido(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() 
    {
        return codigo;
    }

    public String getDescricao()
    {
        return descricao;
    }
}
