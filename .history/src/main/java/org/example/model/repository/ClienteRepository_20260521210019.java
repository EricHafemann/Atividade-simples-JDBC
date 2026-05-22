package org.example.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.config.ConnectionFactory;
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
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                
            }
    } 
    
}
