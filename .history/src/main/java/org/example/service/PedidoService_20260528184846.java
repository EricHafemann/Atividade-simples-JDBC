package org.example.service;

import java.sql.SQLException;

import org.example.model.Pedido;
import org.example.repository.PedidoRepository;

public class PedidoService {

    private final PedidoRepository pedidoRepository = new PedidoRepository();

    public Pedido insertPedido (Pedido pedido) throws SQLException
    {
        validacaoPedido(pedido);

        return pedidoRepository.insertPedido(pedido);
    }

    public List<Pedido> findAll ()
    {
        return pedidoRepository.findAll();
    }

    private void validacaoPedido (Pedido pedido)
    {
        if(pedido.getCliente() == null)
        {
            throw new IllegalArgumentException("O Cliente do Pedido não pode ser nulo!");
        }

        if(pedido.getData_pedido() == null)
        {
            throw new IllegalArgumentException("Data do Pedido não pode ser nula!");
        }

        if(pedido.getPeso() <= 0 )
        {
            throw new IllegalArgumentException("O peso do pedido não pode ser menor ou igual a 0 !");
        }

        if(pedido.getVolume() <= 0 )
        {
            throw new IllegalArgumentException("O volume do pedido não pode ser menor ou igual a 0 !");
        }

        if(pedido.getStatusPedido() == null)
        {
            throw new IllegalArgumentException("O Status não pode ser nulo !");
        }
    }
}
