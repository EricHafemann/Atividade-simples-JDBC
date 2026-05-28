package org.example.service;

import java.sql.Date;
import java.time.LocalDate;

import org.example.model.Entrega;

public class EntregaService {

    public Entrega insertEntrega (Entrega entrega)
    {
        validacaoEntrega(entrega);

        LocalDate date = LocalDate.now();
        Date dataAtual = Date.valueOf(date); 

        if(entrega.getDataEntrega().after(dataAtual))
        {
            throw new IllegalArgumentException("Erro Motorista da entrega não pode ser nulo !");
        }
    }

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

        if(entrega.getDataSaida() == null)
        {
            throw new IllegalArgumentException("Erro Data de Saida não pode ser nulo !");
        }
        
        if(entrega.getStatusEntrega() == null)
        {
            throw new IllegalArgumentException("Erro Status da Entrega não pode ser nulo !");
        }
    }
}
