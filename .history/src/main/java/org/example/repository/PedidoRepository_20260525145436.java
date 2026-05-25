package org.example.repository;

import java.sql.Connection;

import org.example.config.ConnectionFactory;
import org.example.model.Pedido;

public class PedidoRepository {

    public  Pedido insertPedido (Pedido pedido)
    {
        String querySql = """
                INSERT INTO
                    Pedido
                    (data_pedido,
                     volume_m3,
                     peso_kg, 
                     status)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = ConnectionFactory.getConnection())
    }
}
