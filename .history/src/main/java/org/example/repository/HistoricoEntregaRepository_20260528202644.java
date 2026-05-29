package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.config.ConnectionFactory;
import org.example.model.HistoricoEntrega;

public class HistoricoEntregaRepository {

    public HistoricoEntrega inserHistoricoEntrega (HistoricoEntrega historicoEntrega)
    {

        String command = """
                INSERT INTO
                    HistoricoEntrega
                    (entrega_id,
                     data_evento,
                     descricao)
                VALUES
                (?,?,?)
                """;
    }

    try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(com))
}
