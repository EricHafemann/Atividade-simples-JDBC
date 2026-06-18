package org.example.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.exceptions.CpfExistException;
import org.example.exceptions.EntidadeEmUsoException;
import org.example.model.Cliente;
import org.example.repository.ClienteRepository;

public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();
    
    public Cliente insertCliente (Cliente cliente) throws SQLException, CpfExistException, IllegalArgumentException 
    {
        validacaoCliente(cliente);  


        if(clienteRepository.existByCpf(cliente.getCpfCnpj()))
        {
            throw new CpfExistException("CPF já está registrado no sistema !");
        }


        if(cliente.getCpfCnpj().length() < 11)
        {
            throw new IllegalArgumentException("Erro ! Precisa conter no mínmo 11 caracter");
        }

        return clienteRepository.insertClient(cliente);
        
    }

    public List<Cliente> findAll () throws SQLException
    {
        return clienteRepository.findAll();
    }

    public boolean isPossuiPedidos (Long idCliente) throws SQLException
    {
        return clienteRepository.isPossuiPedidos(idCliente);
    }

    public void delete (Long idCliente) throws SQLException, EntidadeEmUsoException
    {

        if(isPossuiPedidos(idCliente))
        {
            throw new EntidadeEmUsoException("-- Entidade em uso ! Impossível remoção --");
        }

        clienteRepository.delete(idCliente);
    }

    private void validacaoCliente (Cliente cliente)
    {
        List<String> estadosValidos = new ArrayList<>(List.of(

            "AC", "AL", "AP", "AM", "BA",
            "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB",
            "PR", "PE", "PI", "RJ", "RN",
            "RS", "RO", "RR", "SC", "SP",
            "SE", "TO"

    ));


        if(cliente.getNome().isBlank())
        {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }

        if(cliente.getCpfCnpj().isBlank())
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

        boolean isEstadoValido = false;

        for(String estado : estadosValidos)
        {
            if(cliente.getEstado().equalsIgnoreCase(estado))
            {
                isEstadoValido = true;
                break;
            }
        }

        if(!isEstadoValido)
        {
            throw new IllegalArgumentException("Estado escolhido não existe !");
        }
    }
}
