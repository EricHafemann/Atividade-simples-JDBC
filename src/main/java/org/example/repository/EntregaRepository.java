package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.config.ConnectionFactory;
import org.example.model.Cliente;
import org.example.model.Entrega;
import org.example.model.Motorista;
import org.example.model.Pedido;
import org.example.model.enums.StatusEntrega;
import org.example.model.enums.StatusPedido;

public class EntregaRepository {


    public Entrega insertEntrega (Entrega entrega) throws SQLException
    {
        
        String querySql = """
                INSERT INTO
                    Entrega
                    (pedido_id,
                     motorista_id,
                     data_saida,
                     data_entrega,
                     status)
                VALUES
                (?,?,?,?,?)
                """;

            try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(querySql, Statement.RETURN_GENERATED_KEYS))
                {
                    stmt.setLong(1, entrega.getPedido().getId());
                    stmt.setLong(2, entrega.getMotorista().getId());
                    stmt.setDate(3, entrega.getDataSaida());
                    stmt.setDate(4, entrega.getDataEntrega());
                    stmt.setString(5, entrega.getStatusEntrega().getDescricao());

                    stmt.executeUpdate();

                    ResultSet rs = stmt.getGeneratedKeys();

                    if(rs.next())
                    {
                        entrega.setId(rs.getLong(1));
                    }

                    return entrega;
                }
    }

    public List<Entrega> findAll () throws SQLException
    {
        List<Entrega> entregas = new ArrayList<>();

        String querySql = """
                SELECT 
                    e.id, e.pedido_id, e.motorista_id, e.data_saida, e.data_entrega, e.status,
                    p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status,
                    m.id, m.nome, m.cnh, m.veiculo, m.cidade_base,
                    c.id, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado
                FROM Entrega e
                LEFT JOIN Pedido p ON e.pedido_id = p.id
                LEFT JOIN Motorista m ON e.motorista_id = m.id
                LEFT JOIN Cliente c ON p.cliente_id = c.id
                """;   
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    
                    Cliente cliente = new Cliente
                    (
                        rs.getLong("c.id"),
                        rs.getString("c.nome"),
                        rs.getString("c.cpf_cnpj"),
                        rs.getString("c.endereco"),
                        rs.getString("c.cidade"),
                        rs.getString("c.estado")
                    );

                    Motorista motorista = new Motorista
                    (
                        rs.getLong("m.id"),
                        rs.getString("m.nome"),
                        rs.getString("m.veiculo"),
                        rs.getString("m.cnh"),
                        rs.getString("m.cidade_base")
                    );

                    Pedido pedido = new Pedido
                    (
                        rs.getLong("p.id"),
                        cliente,
                        rs.getDate("p.data_pedido"),
                        rs.getDouble("p.volume_m3"),
                        rs.getDouble("p.peso_kg"),
                        StatusPedido.fromDescricao(rs.getString("p.status"))
                    );

                    Entrega entrega = new Entrega
                    (
                        rs.getLong("e.id"),
                        pedido,
                        motorista,
                        rs.getDate("e.data_saida"),
                        rs.getDate("e.data_entrega"),
                        StatusEntrega.fromDescricao(rs.getString("e.status"))
                    );


                    entregas.add(entrega);
                }

                return entregas;
            }
    }

    public void updateEntrega (Entrega entrega) throws SQLException
    {
        String querySql = """

                UPDATE Entrega set  
                    pedido_id = ?,
                    motorista_id = ?,
                    data_saida = ?,
                    data_entrega = ?,
                    status = ?
                WHERE id = ?
                
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                stmt.setLong(1, entrega.getPedido().getId());
                stmt.setLong(2, entrega.getMotorista().getId());
                stmt.setDate(3, entrega.getDataSaida());
                stmt.setDate(4, entrega.getDataEntrega());
                stmt.setString(5, entrega.getStatusEntrega().getDescricao());

                stmt.setLong(6, entrega.getId());

                stmt.executeUpdate();
            }
    }

    public List<HashMap<String, Integer>> countEntregasByMotorista () throws SQLException
    {

        List<HashMap<String, Integer>>  listaEntregasPorMotorista = new ArrayList();

        String querySql = """
                SELECT m.nome, COUNT(e.motorista_id) AS Total_Entregas
                FROM Motorista m
                LEFT JOIN Entrega e ON e.motorista_id = m.id
                GROUP BY m.id, m.nome;   
                """;


        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    HashMap<String, Integer> entregasPorMotorista = new HashMap<>();
                    
                    entregasPorMotorista.put(rs.getString("nome"), rs.getInt("Total_Entregas"));

                    listaEntregasPorMotorista.add(entregasPorMotorista);

                }

                return listaEntregasPorMotorista;
            }
    }

    public List<HashMap<String, Integer>> rankEntregasByClientes () throws SQLException
    {
        List<HashMap<String, Integer>>  listarRankEntregaByClientes = new ArrayList();

        String querySql = """
                SELECT 
                    c.nome, 
                    COALESCE(COUNT(e.id), 0) AS Total_Entregas 
                FROM Cliente c
                LEFT JOIN Pedido p ON p.cliente_id = c.id 
                LEFT JOIN Entrega e ON e.pedido_id = p.id AND e.status = 'Entregue'
                GROUP BY c.id, c.nome 
                ORDER BY Total_Entregas DESC;   
                """;
                
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    HashMap<String, Integer> entregasPorCliente = new HashMap<>();
                    
                    entregasPorCliente.put(rs.getString("nome"), rs.getInt("Total_Entregas"));

                    listarRankEntregaByClientes.add(entregasPorCliente);

                }

                return listarRankEntregaByClientes;
            }
    }

    public List<HashMap<String, Integer>> entregasAtrasadasPorCidade () throws SQLException
    {
        List<HashMap<String, Integer>>  listarEntregasAtrasadasPorCidade = new ArrayList();

        String querySql = """
                SELECT 
                    c.cidade,
                    COALESCE(COUNT(e.id), 0) AS quantidade
                FROM Cliente c
                LEFT JOIN Pedido p ON p.cliente_id = c.id
                LEFT JOIN Entrega e ON e.pedido_id = p.id AND e.status = 'ATRASADA'
                GROUP BY c.cidade
                ORDER BY quantidade DESC
                """;
                
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
            {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {

                    HashMap<String, Integer> entregasAtrasadasPorCidade = new HashMap<>();
                    
                    entregasAtrasadasPorCidade.put(rs.getString("cidade"), rs.getInt("quantidade"));

                    listarEntregasAtrasadasPorCidade.add(entregasAtrasadasPorCidade);

                }

                return listarEntregasAtrasadasPorCidade;
            }
    }

    public Entrega findById(Long id) throws SQLException
    {
        String querySql = """
                SELECT 
                    e.id, e.pedido_id, e.motorista_id, e.data_saida, e.data_entrega, e.status,
                    p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status,
                    m.id, m.nome, m.cnh, m.veiculo, m.cidade_base,
                    c.id, c.nome, c.cpf_cnpj, c.endereco, c.cidade, c.estado
                FROM Entrega e
                LEFT JOIN Pedido p ON e.pedido_id = p.id
                LEFT JOIN Motorista m ON e.motorista_id = m.id
                LEFT JOIN Cliente c ON p.cliente_id = c.id
                WHERE e.id = ?
                """;
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                Cliente cliente = new Cliente
                (
                    rs.getLong("c.id"),
                    rs.getString("c.nome"),
                    rs.getString("c.cpf_cnpj"),
                    rs.getString("c.endereco"),
                    rs.getString("c.cidade"),
                    rs.getString("c.estado")
                );
                
                Motorista motorista = new Motorista
                (
                    rs.getLong("m.id"),
                    rs.getString("m.nome"),
                    rs.getString("m.veiculo"),
                    rs.getString("m.cnh"),
                    rs.getString("m.cidade_base")
                );
                
                Pedido pedido = new Pedido
                (
                    rs.getLong("p.id"),
                    cliente,
                    rs.getDate("p.data_pedido"),
                    rs.getDouble("p.volume_m3"),
                    rs.getDouble("p.peso_kg"),
                    StatusPedido.fromDescricao(rs.getString("p.status"))
                );
                
                Entrega entrega = new Entrega
                (
                    rs.getLong("e.id"),
                    pedido,
                    motorista,
                    rs.getDate("e.data_saida"),
                    rs.getDate("e.data_entrega"),
                    StatusEntrega.fromDescricao(rs.getString("e.status"))
                );
                
                return entrega;
            }
            
            return null;
        }
    }

    public void delete(Long id) throws SQLException
    {
        String querySql = "DELETE FROM Entrega WHERE id = ?";
        
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(querySql))
        {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

}
