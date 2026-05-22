package org.example.model.enums;

public enum Status {

    PENDENTE(1, "PENDENTE"),
    ENTREGUE(2),
    CANCELADO(3);

    private int codigo;
    private String descricao;

    private Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    
}
