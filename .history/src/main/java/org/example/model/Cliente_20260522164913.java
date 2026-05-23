package org.example.model;

public class Cliente extends Usuario{

    private String cpf_cnpj;
    private String endereco;
    private String cidade;
    private String estado;
    
    public Cliente(Long id, String nome, String cpf_cnpj, String endereco, String cidade, String estado) {
        super(id, nome);
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente(String nome, String cpf_cnpj, String endereco, String cidade, String estado) {
        super(nome);
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }
    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void exibirInfo ()
    {
        System.out.println("--+ Informações do Cliente +--");
        System.out.println();
        System.out.println("= ID:       "+getId());
        System.out.println("= NOME:     "+getNome());
        System.out.println("= CPF/CNPJ: "+getC());
    }
}
