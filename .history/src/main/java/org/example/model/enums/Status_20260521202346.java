package org.example.model.enums;

public enum Status {

    PENDENTE(1, "PENDENTE"),
    ENTREGUE(2, "ENTREGUE"),
    CANCELADO(3, "CANCELADO");

    private int codigo;
    private String descricao;

    private Status(int codigo, String descricao) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    
}
