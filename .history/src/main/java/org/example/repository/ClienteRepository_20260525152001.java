package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.example.config.ConnectionFactory;
import org.example.model.Cliente;

public class ClienteRepository {

    public Cliente insertClient (Cliente cliente) throws SQLException
    {

        String sql = """
                INSERT INTO Cliente
                    (nome, 
                    cpf_cnpj, 
                    endereco, 
                    cidade, 
                    estado)
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

                if(rs.next())
                {
                    cliente.setId(rs.getLong(1));
                }

                return cliente;
            }
    } 

    public boolean existByCpf (String cpf) throws SQLException
    {
        boolean exit = false;

        String sql = """
                SELECT 
                    id 
                FROM 
                Cliente 
                WHERE 
                cpf_cnpj = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {

                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();

                if(rs.next())
                {
                    exit = true;
                }
                return exit;
            }
    }

    public List<Cliente> findAll ()
    {
        String sql = """
                SELECT 
                    (id,
                     nome,
                     cpf_cnpj,
                     endereco,
                     cidade,
                     estado)
                FROM 
                Cliente 
                """;
        
        try(Connection conn = Conn)
    }
    
}
