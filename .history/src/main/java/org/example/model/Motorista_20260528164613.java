package org.example.model;

public class Motorista extends Usuario {

    private String cnh;
    private String veiculo;
    private String cidade_base;

    public Motorista(Long id,String nome, String cidade_base, String cnh, String veiculo) {
        super(id, nome);
        this.cidade_base = cidade_base;
        this.cnh = cnh;
        this.veiculo = veiculo;
    }

    public Motorista(String cidade_base, String cnh, String veiculo, String nome) {
        super(nome);
        this.cidade_base = cidade_base;
        this.cnh = cnh;
        this.veiculo = veiculo;
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

    @Override
    public void exibirInfo ()
    {
        System.out.println("+-+ Informações do Cliente +-=");
        System.out.println("= ID:          "+getId());
        System.out.println("= NOME:        "+getNome());
        System.out.println("= Cidade Base: "+getCidade_base());
        System.out.println("= CNH:         "+getCnh());
        System.out.println("= Veiculo:     "+getVeiculo());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
}
