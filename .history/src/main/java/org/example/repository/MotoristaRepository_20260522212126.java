package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.config.ConnectionFactory;
import org.example.model.Motorista;

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
            PreparedStatement stmt = conn.prepareStatement(sql))
            {
                s
            }


    }

    
}

