package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.config.ConnectionFactory;
import org.example.model.Cliente;
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
            PreparedStatement stmt = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS))
            {
                stmt.setLong(1, pedido.getCliente().getId());
                stmt.setDouble(2, pedido.getVolume());
                stmt.setDouble(3, pedido.getPeso());
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

    public List<Pedido> findAll () throws SQLException
    {
        List<Pedido> pedidos = new ArrayList<>();

        String querySql = """
                SELECT 
                    id,
                    cliente_id,
                    data_pedido,
                    volume_m3,
                    peso_kg,
                    status
                FROM Pedido p
                LEFT JOIN Cliente c ON p.cliente_id = c.cliente_id 
                
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    

                    Entrega entrega = new Entrega()

                        rs.getLong("p.id"),
                        ,
                        rs.getDate("p.data_pedido"),
                        rs.getDouble("p.volume_m3"),
                        rs.getDouble("p.peso_kg"),
                        rs.getString("p.status")
                    )
                }
            }
    }
}
