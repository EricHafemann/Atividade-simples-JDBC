package org.example.model.repository;

import java.beans.Statement.;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf_cnpj());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getCidade());
                stmt.setString(5, cliente.getEstado());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if()
            }
    } 
    
}
