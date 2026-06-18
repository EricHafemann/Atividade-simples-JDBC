package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.config.ConnectionFactory;
import org.example.model.Motorista;

public class MotoristaRepository {

    public Motorista inseMotorista (Motorista motorista) throws SQLException
    {
        
        String querySql = """
                INSERT 
                INTO Motorista
                    (nome, 
                    cnh, 
                    veiculo,
                    cidade_base)
                VALUES
                (?,?,?,?)
                """;

            try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS))
            {
                stmt.setString(1, motorista.getNome()); 
                stmt.setString(2, motorista.getCnh()); 
                stmt.setString(3, motorista.getVeiculo()); 
                stmt.setString(4, motorista.getCidade_base()); 

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next())
                {
                    motorista.setId(rs.getLong(1));
                }

                return motorista;
            }

    }

    public boolean existByCnh(String cnh) throws SQLException
    {
        boolean exit = false;

        String sql = """
                SELECT 
                    id 
                FROM 
                Motorista 
                WHERE 
                cnh = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql))
            {

                stmt.setString(1, cnh);

                ResultSet rs = stmt.executeQuery();

                if(rs.next())
                {
                    exit = true;
                }
                return exit;
            }
    }

    public List<Motorista> findAll() throws SQLException
    {

        List<Motorista> motoristas = new ArrayList<>();

        String querySql = """
                SELECT 
                    id,
                    nome, 
                    cnh, 
                    veiculo,
                    cidade_base
                FROM Motorista
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Motorista motorista = new Motorista(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));

                    motoristas.add(motorista);
                }

                return motoristas;

            }
    }

    public boolean isPossuiEntregas (Long idMotorista) throws SQLException
    {

        String querySql = """
                SELECT 
                    COUNT(*) AS Quantidade_Entregas
                FROM Entrega e
                WHERE e.motorista_id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                stmt.setLong(1, idMotorista);

                ResultSet rs = stmt.executeQuery();

                if(rs.next())
                {
                    if(rs.getInt("Quantidade_Entregas") > 0)
                    {
                        return true;
                    }
                }

                return false;
            }
    }

     public int delete (Long idMotorista) throws SQLException 
    {
        String querySql = """
                DELETE FROM Motorista WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setLong(1, idMotorista);

            return stmt.executeUpdate();

        }
        
    }

    
}

