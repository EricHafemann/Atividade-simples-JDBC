package org.example.repository;

import java.sql.Connection;
import java.sql.SQLException;

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
    }

    try(Connection conn = Conner)
}
