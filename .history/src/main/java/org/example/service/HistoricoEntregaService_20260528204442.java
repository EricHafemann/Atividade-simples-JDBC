package org.example.service;

import org.example.model.HistoricoEntrega;
import org.example.repository.HistoricoEntregaRepository;

public class HistoricoEntregaService {

    private static final HistoricoEntregaRepository HistoricoEntregaRepository = new HistoricoEntregaRepository();

    public HistoricoEntrega inserHistoricoEntrega (HistoricoEntrega historicoEntrega)
    {
        return historicoEntrega;

    }

    public void validacaoHistoricoEntrega (HistoricoEntrega historicoEntrega)
    {
        if(historicoEntrega.getDataEvento() == null)
        {
            th
        }
    }
}
