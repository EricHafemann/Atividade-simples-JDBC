package org.example.service;

import org.example.model.Entrega;

public class EntregaService {

    public void validacaoEntrega(Entrega entrega)
    {
        if(entrega.getMotorista() == null)
        {
            throw new IllegalArgumentException("Erro Motorista da entrega não pode ser nulo")
        }
    }
}
