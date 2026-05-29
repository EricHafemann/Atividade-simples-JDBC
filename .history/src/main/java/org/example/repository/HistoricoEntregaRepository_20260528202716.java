package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.example.config.ConnectionFactory;
import org.example.model.HistoricoEntrega;

public class HistoricoEntregaRepository {

    public HistoricoEntrega inserHistoricoEntrega (HistoricoEntrega historicoEntrega) throws SQLException
    {

        String querySql = """
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
        PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS))
        {

        }
}
