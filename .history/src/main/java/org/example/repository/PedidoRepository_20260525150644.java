package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.config.ConnectionFactory;
import org.example.model.Pedido;

public class PedidoRepository {

    public  Pedido insertPedido (Pedido pedido) throws SQLException
    {
        String querySql = """
                INSERT INTO
                    Pedido
                    (cliente_id,
                     volume_m3,
                     peso_kg, 
                     status)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                stmt.setInt(1, pedido.getCliente().getId());
                stmt.setDouble(2, pedido.getVolume_m3());
                stmt.setDouble(3, pedido.getPeso_kg());
                stmt.setString(4, pedido.getStatusPedido().getDescricao());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();

                if(rs.next())
                {
                    pedido.setId(rs.getLong(1));
                }

                return pedido;
            }
    }
}
