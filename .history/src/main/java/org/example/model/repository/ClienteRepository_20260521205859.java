package org.example.model.repository;

import java.sql.Connection;

import org.example.model.Cliente;

public class ClienteRepository {

    public Cliente insertClient (Cliente cliente)
    {

        String sql = """
                INSERT INTO Cliente
                    nome, 
                    cpf_cnpj, 
                    endereco, 
                    cidade, 
                    estado
                VALUES
                (?,?,?,?,?)
                """;
        
        try(Connection conn = )
    } 
    
}
