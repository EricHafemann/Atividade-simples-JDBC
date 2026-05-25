package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.exceptions.CpfExistException;
import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();
    
    public Cliente insertCliente (Cliente cliente) throws SQLException, CpfExistException, IllegalArgumentException 
    {
        validacaoCliente(cliente);  


        if(clienteRepository.existByCpf(cliente.getCpf_cnpj()))
        {
            throw new CpfExistException("CPF já está registrado no sistema !");
        }

        return clienteRepository.insertClient(cliente);
        
    }

    public List<Cliente> findAll ()
    {
        return clienteRepository.insertClient();
    }

    private void validacaoCliente (Cliente cliente)
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

        if(cliente.getEstado().length() != 2)
        {
            String menssagem = """
                    Estado precisa estar no padrão de sigla:
                    Exemplo: São Paulo -> SP
                    """;

            throw new IllegalArgumentException(menssagem);
        }
    }
}
