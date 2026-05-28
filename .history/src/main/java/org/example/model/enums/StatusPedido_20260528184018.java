package org.example.model.enums;

public enum StatusPedido {

    PENDENTE(1, "PENDENTE"),
    ENTREGUE(2, "ENTREGUE"),
    CANCELADO(3, "CANCELADO");

    private int codigo;
    private String descricao;

    private StatusPedido(int codigo, String descricao) {
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

    public StatusPedido fromDescricao (String descricao)
    {
        for(StatusPedido status : StatusPedido.values())
        {
            if(status.getDescricao())
        }
    }

    
}
