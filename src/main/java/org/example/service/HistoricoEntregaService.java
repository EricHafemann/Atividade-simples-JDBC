package org.example.service;

import java.sql.SQLException;

import org.example.model.HistoricoEntrega;
import org.example.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {

    private final HistoricoEntregaRepository historicoEntregaRepository = new HistoricoEntregaRepository();

    public HistoricoEntrega insertHistoricoEntrega (HistoricoEntrega historicoEntrega) throws SQLException
    {
        validacaoHistoricoEntrega(historicoEntrega);

        if(historicoEntrega.getDescricao().length() < 5)
        {
            throw new IllegalArgumentException("Erro! Descrição precisa ter ao menos 5 caracteres. ");
        }

        return historicoEntregaRepository.inserHistoricoEntrega(historicoEntrega);

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
