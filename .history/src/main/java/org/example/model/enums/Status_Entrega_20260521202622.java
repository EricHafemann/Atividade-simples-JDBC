package org.example.model.enums;

public class Status_Entrega {
    
    EMROTA(1, "EM_ROTA"),
    ENTREGUE(2, "ENTREGUE"),
    ATRASADA(3, "ATRASADA");

    private int codigo;
    private String descricao;

    public Status_Entrega(int codigo, String descricao) {
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
