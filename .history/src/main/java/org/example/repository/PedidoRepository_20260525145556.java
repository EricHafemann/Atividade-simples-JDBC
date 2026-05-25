package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.config.ConnectionFactory;
import org.example.model.Pedido;

public class PedidoRepository {

    public  Pedido insertPedido (Pedido pedido) throws SQLException
    {
        String querySql = """
                INSERT INTO
                    Pedido
                    
                     volume_m3,
                     peso_kg, 
                     status)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                stmt.set
            }
    }
}
