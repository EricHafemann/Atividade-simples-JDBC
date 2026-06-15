package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.config.ConnectionFactory;
import org.example.model.Cliente;
import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;


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
                    p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status,
                    c.id, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado
                FROM Pedido p
                LEFT JOIN Cliente c ON p.cliente_id = c.id
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {


                    

                    Pedido pedido = new Pedido(
                        rs.getLong("p.id"),
                            new Cliente(
                                    rs.getLong("c.id"), 
                                    rs.getString("c.nome"), 
                                    rs.getString("c.cpf_cnpj"), 
                                    rs.getString("c.endereco"), 
                                    rs.getString("c.cidade"), 
                                    rs.getString("c.estado")),
                        rs.getDate("p.data_pedido"),
                        rs.getDouble("p.volume_m3"),
                        rs.getDouble("p.peso_kg"),
                        StatusPedido.fromDescricao(rs.getString("p.status"))
                    );

                    pedidos.add(pedido);
                }

                return pedidos;
            }
    }

    public void updatePedido (Pedido pedido) throws SQLException
    {

        String querySql = """
                UPDATE Pedido set
                    cliente_id = ?,
                    data_pedido = ?,
                    volume_m3 = ?,
                    peso_kg = ?,
                    status = ?
                WHERE id = ?
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                stmt.setLong(1, pedido.getCliente().getId());
                stmt.setDate(2, pedido.getData_pedido());
                stmt.setDouble(3, pedido.getVolume());
                stmt.setDouble(4, pedido.getPeso());
                stmt.setString(5, pedido.getStatusPedido().getDescricao());

                stmt.setLong(6, pedido.getId());

                stmt.executeUpdate();
            }
    }

    public List<HashMap<String, Integer>>  pedidosPendentesPorEstado () throws SQLException
    {

        List<HashMap<String, Integer>> listPedidosPendentesPorEstado = new ArrayList<>();

        String querySql = """
                SELECT 
                    c.estado,
                    COUNT(p.id) as quantidade
                FROM Pedido p
                LEFT JOIN Cliente c ON c.id = p.cliente_id
                WHERE p.status = 'PENDENTE'
                GROUP BY c.estado
                ORDER BY quantidade desc;
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HashMap<String, Integer> pedidosPendentesPorEstado = new HashMap<>();

                pedidosPendentesPorEstado.put(rs.getString("estado"), rs.getInt("quantidade"));

                listPedidosPendentesPorEstado.add(pedidosPendentesPorEstado);
            }

            return listPedidosPendentesPorEstado;
        }
    }

    public List<Pedido> buscarPedidosPorDocumento(String documento) throws SQLException {
    List<Pedido> pedidos = new ArrayList<>();
    
    String querySql = "SELECT p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status, " +
                 "c.id, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado " +
                 "FROM Pedido p " +
                 "LEFT JOIN Cliente c ON c.id = p.cliente_id " +
                 "WHERE c.cpf_cnpj = ?";
    
    try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(querySql)) {
        stmt.setString(1, documento);
        
            try(ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {

                    Cliente cliente = new Cliente(
                        rs.getLong("c.id"),
                        rs.getString("c.nome"),
                        rs.getString("c.cpf_cnpj"),
                        rs.getString("c.endereco"),
                        rs.getString("c.cidade"),
                        rs.getString("c.estado")
                    );
        
                    Pedido pedido = new Pedido(
                        rs.getLong("p.id"),
                        cliente,
                        rs.getDate("p.data_pedido"),
                        rs.getDouble("p.volume_m3"),
                        rs.getDouble("p.peso_kg"),
                        StatusPedido.fromDescricao(rs.getString("p.status"))
                    );

        
                pedidos.add(pedido);
            }
        }
    }
    
    return pedidos;
}

public Pedido buscarPorId(Long id) throws SQLException {
    String querySql = "SELECT p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status, " +
                 "c.id, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado " +
                 "FROM Pedido p " +
                 "INNER JOIN Cliente c ON c.id = p.cliente_id " +
                 "WHERE p.id = ?";
    
    try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(querySql)) {
        stmt.setLong(1, id);
        
        try(ResultSet rs = stmt.executeQuery()) {
            if(rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getLong("c.id"),
                    rs.getString("c.nome"),
                    rs.getString("c.cpf_cnpj"),
                    rs.getString("c.endereco"),
                    rs.getString("c.cidade"),
                    rs.getString("c.estado")
                );
                
                return new Pedido(
                    rs.getLong("p.id"),
                    cliente,
                    rs.getDate("p.data_pedido"),
                    rs.getDouble("p.volume_m3"),
                    rs.getDouble("p.peso_kg"),
                    StatusPedido.valueOf(rs.getString("p.status"))
                );
            }
        }
    }
    
    return null;
}

public void atualizarStatus(Long idPedido, StatusPedido status) throws SQLException {
    String querySql = "UPDATE Pedido SET status = ? WHERE id = ?";
    
    try(Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(querySql)) {
        stmt.setString(1, status.getDescricao());
        stmt.setLong(2, idPedido);
        stmt.executeUpdate();
    }
}

    
}