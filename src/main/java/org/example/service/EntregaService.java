package org.example.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.example.model.Entrega;
import org.example.repository.EntregaRepository;

public class EntregaService {

    private final static EntregaRepository entregaRepository = new EntregaRepository();

    public Entrega insertEntrega (Entrega entrega) throws SQLException
    {
        validacaoEntrega(entrega);

        LocalDate date = LocalDate.now();
        Date dataAtual = Date.valueOf(date); 

        if(entrega.getDataEntrega().before(dataAtual))
        {
            throw new IllegalArgumentException("Erro Data de entrega tem que ser Futura !");
        }

        if(entrega.getDataEntrega().before(entrega.getDataSaida()))
        {
            throw new IllegalArgumentException("Erro Data de entrega precisa ser deposi da de Saida !");
        }

        return entregaRepository.insertEntrega(entrega);
    }

    public List<Entrega> findAll () throws SQLException
    {
        return entregaRepository.findAll();
    }

    public void updateEntrega (Entrega entrega) throws SQLException
    {
        entregaRepository.updateEntrega(entrega);
    }

    public List<HashMap<String, Integer>> countEntregasByMotoristas () throws SQLException
    {
        return entregaRepository.countEntregasByMotorista();
    }

    public List<HashMap<String, Integer>> rankEntregaByClientes () throws SQLException
    {
        return entregaRepository.rankEntregasByClientes();
    }

    public List<HashMap<String, Integer>> entregasAtrasadasPorCidade () throws SQLException
    {
        return entregaRepository.entregasAtrasadasPorCidade();
    }

    public void delete(Long id) throws SQLException
    {
        entregaRepository.delete(id);
    }

    public Entrega findById (Long idEntrega) throws SQLException 
    {
        return entregaRepository.findById(idEntrega);
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
