package org.example.service;

import org.example.model.HistoricoEntrega;
import org.example.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {

    private static final HistoricoEntregaRepository HistoricoEntregaRepository = new HistoricoEntregaRepository();

    public HistoricoEntrega inserHistoricoEntrega (HistoricoEntrega historicoEntrega)
    {
        validacaoHistoricoEntrega(historicoEntrega);

        return historicoEntrega;

    }

    public void validacaoHistoricoEntrega (HistoricoEntrega historicoEntrega)
    {
        if(historicoEntrega.getDataEvento() == null)
        {
            throw new IllegalArgumentException("Erro! Data do Evento não pode ser nula. ");
        }

        if(historicoEntrega.getDescricao() == null)
        {
            throw new IllegalArgumentException("Erro! Descrição não pode ser nula. ");
        }

        if(historicoEntrega.getEntrega() == null)
        {
            throw new IllegalArgumentException("Erro! Entrega não pode ser nula. ");
        }
    }
}
