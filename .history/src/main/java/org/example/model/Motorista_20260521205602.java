package org.example.model;

public class Motorista extends  {

    private String cnh;
    private String veiculo;
    private String cidade_base;
    
    public Motorista(String cnh, String veiculo, String cidade_base) {
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidade_base = cidade_base;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCidade_base() {
        return cidade_base;
    }

    public void setCidade_base(String cidade_base) {
        this.cidade_base = cidade_base;
    }

    
}
