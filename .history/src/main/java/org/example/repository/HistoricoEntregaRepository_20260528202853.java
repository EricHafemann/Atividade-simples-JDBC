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

        try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, historicoEntrega.getEntrega().getId());
            stmt.setDate(2, historicoEntrega.getDataEvento());
            stmt.setString(3, historicoEntrega.getDescricao());

            stmt.exe
        }
    }
}
