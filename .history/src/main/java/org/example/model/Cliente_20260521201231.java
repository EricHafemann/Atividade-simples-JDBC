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

    

}
