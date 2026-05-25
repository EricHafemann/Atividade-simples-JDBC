package org.example.repository;

import org.example.model.Pedido;

public class PedidoRepository {

    public  Pedido insertPedido (Pedido pedido)
    {
        String querySql = """
                INSERT INTO
                    (data_pedido,
                     volume_m3,
                     peso_kg, 
                    status)
                """;
    }
}
