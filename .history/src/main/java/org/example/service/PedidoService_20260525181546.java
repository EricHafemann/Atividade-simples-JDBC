package org.example.service;

import org.example.model.Pedido;

public class PedidoService {

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

        if(pedido.getPeso_kg() <= 0 )
        {
            throw new IllegalArgumentException("O peso do pedido não pode ser menor ou igual a 0 !");
        }

        if(pedido.getVolume_m3() <= 0 )
        {
            throw new IllegalArgumentException("O volume do pedido não pode ser menor ou igual a 0 !");
        }

        if(pedido.getStatusPedido() == null)
        {
            throw new IllegalArgumentException("O volume do pedido não pode ser menor ou igual a 0 !");
        }
    }
}
