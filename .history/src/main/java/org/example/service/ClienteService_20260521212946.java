package org.example.service;

import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class ClienteService {

    private final static ClienteRepository clienteRepository = new ClienteRepository();
    
    public Cliente insertCliente (Cliente cliente) 
    {
        if(cliente.getNome().isBlank())
        {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }

        if(cliente.getNome().isBlank())
        {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }
    }
}
