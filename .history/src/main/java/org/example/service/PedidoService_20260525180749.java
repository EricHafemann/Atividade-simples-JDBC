package org.example.service;

import org.example.model.Motorista;
import org.example.model.Pedido;

public class PedidoService {

    private void validacaoPedido (Pedido pedido)
    {
        if(pedido.)
        {
            throw new IllegalArgumentException("Nome não pode ser nulo!");
        }

        if(motorista.getCnh().isBlank())
        {
            throw new IllegalArgumentException("CNH não pode ser nula!");
        }

        if(motorista.getCnh().length() != 20)
        {
            throw new IllegalArgumentException("CNH precisa conter 20 caracteres !");
        }


        if(motorista.getVeiculo().isBlank())
        {
            throw new IllegalArgumentException("Veículo não pode ser nulo!");
        }

        if(motorista.getCidade_base().isBlank())
        {
            throw new IllegalArgumentException("Cidade Base não pode ser nula!");
        }
    }
}
