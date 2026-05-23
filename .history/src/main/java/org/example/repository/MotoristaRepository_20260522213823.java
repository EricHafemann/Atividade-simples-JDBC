package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.config.ConnectionFactory;
import org.example.model.Motorista;

import com.mysql.cj.xdevapi.Result;

public class MotoristaRepository {

    public Motorista inseMotorista (Motorista motorista) throws SQLException
    {
        
        String querySql = """
                INSERT 
                INTO MOTORISTA 
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
                    motorista.setId(id);
                }

                return motorista;
            }

    }

    
}

