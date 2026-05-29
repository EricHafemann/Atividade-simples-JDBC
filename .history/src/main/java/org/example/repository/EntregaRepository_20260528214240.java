package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.example.config.ConnectionFactory;
import org.example.model.Entrega;
import org.example.model.Pedido;

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
        String querySql = """
                SELECT 
                    e.id, e.pedido_id, e.motorista_id, e.data_saida, e.data_entrega, e.status,
                    p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status,
                    m.id, m.nome, m.cnh, m.veiculo, m.cidade_base,
                    c.id, nome, cpf_cnpj, endereco, cidade, estado
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
                    

                }
                
            }
        return null;
    }
}
