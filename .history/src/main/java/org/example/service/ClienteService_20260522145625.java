package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class ClienteService {

    private final static ClienteRepository clienteRepository = new ClienteRepository();
    
    public Cliente insertCliente (Cliente cliente) 
    {
        validacaoCliente(cliente);  

        if(cliente.getCpf_cnpj())
        
    }

    public void validacaoCliente (Cliente cliente)
    {
        if(cliente.getNome().isBlank())
        {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }

        if(cliente.getCpf_cnpj().isBlank())
        {
            throw new IllegalArgumentException("CPF ou CNPJ não pode ser nulo!");
        }

        if(cliente.getEndereco().isBlank())
        {
            throw new IllegalArgumentException("Endereço não pode ser nulo!");
        }

        if(cliente.getCidade().isBlank())
        {
            throw new IllegalArgumentException("Cidade não pode ser nulo!");
        }

        if(cliente.getEstado().isBlank())
        {
            throw new IllegalArgumentException("Estado não pode ser nulo!");
        }
    }
}
