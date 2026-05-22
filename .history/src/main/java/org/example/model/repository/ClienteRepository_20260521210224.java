package org.example.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.config.ConnectionFactory;
import org.example.model.Cliente;

public class ClienteRepository {

    public Cliente insertClient (Cliente cliente) throws SQLException
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
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf_cnpj());
                stmt.setString(3, cliente.getEndereco());
                stmt.set
            }
    } 
    
}
