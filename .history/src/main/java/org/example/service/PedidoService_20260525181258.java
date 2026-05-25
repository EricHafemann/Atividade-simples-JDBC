package org.example.service;

import org.example.model.Motorista;
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

        if(pedido.getPeso_kg()null)
        {
            throw new IllegalArgumentException("Veículo não pode ser nulo!");
        }

        
    }
}
