package org.example.service;

import org.example.model.Entrega;

public class EntregaService {

    public void validacaoEntrega(Entrega entrega)
    {
        if(entrega.getMotorista() == null)
        {
            throw new IllegalArgumentException("Erro Motorista da entrega não pode ser nulo !");
        }

        if(entrega.getPedido() == null)
        {
            throw new IllegalArgumentException("Erro Pedido da entrega não pode ser nulo !");
        }

        if(entrega.getDataEntrega() == null)
        {
            throw new IllegalArgumentException("Erro Data da Entrega não pode ser nulo !");
        }

        if(entrega.getDataSaida()() == null)
        {
            throw new IllegalArgumentException("Erro Data da Entrega não pode ser nulo !");
        }
    }
}
