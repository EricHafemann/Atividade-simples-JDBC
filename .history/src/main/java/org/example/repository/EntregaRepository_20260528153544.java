package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.config.ConnectionFactory;
import org.example.model.Entrega;

public class EntregaRepository {


    public Entrega insertEntrega ()
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
    }
}
