package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.config.ConnectionFactory;
import org.example.model.Entrega;

public class EntregaRepository {


    public Entrega insertEntrega (Entrega entrega) throws SQLException
    {
        
        String querySql = """
                INSERT INTO
                    (pedido_id,
                     motorista_id,
                     data_saida,
                     data_entrega,
                     status)
                VALUES
                (?,?,?,?,?)
                """;

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(querySql))
                {
                    stmt.setLong(1, entrega.getPedido().getId());
                    stmt.setLong(2, entrega.getMotorista().getId());
                    stmt.setDate(3, entrega.getDataSaida());
                    stmt.setDate(4, entrega.getDataEntrega());
                    
                }
    }
}
