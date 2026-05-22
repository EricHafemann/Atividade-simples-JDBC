package org.example.model.enums;

public enum Status {

    PENDENTE;

    private int codigo;

    private Status(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    
}
