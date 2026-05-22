package org.example.model.enums;

public enum Status {

    PENDENTE(1),
    ENTREGUE(2),
    CANCELADO(3),
    EM_ROTA();

    private int codigo;

    private Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    
}
