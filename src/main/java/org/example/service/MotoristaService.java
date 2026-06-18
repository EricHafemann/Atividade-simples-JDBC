package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.exceptions.CnhExistException;
import org.example.exceptions.EntidadeEmUsoException;
import org.example.model.Motorista;
import org.example.repository.MotoristaRepository;

public class MotoristaService {

    private final MotoristaRepository motoristaRepository = new MotoristaRepository();
    
    public Motorista insertMotorista (Motorista motorista) throws SQLException, CnhExistException
    {
        validacaoMotorista(motorista);

        if(motoristaRepository.existByCnh(motorista.getCnh()))
        {
            throw new CnhExistException("CNH já está registrada no sistema !");
        }

        return motoristaRepository.inseMotorista(motorista);

    }

    public List<Motorista> findAll () throws SQLException
    {
        return motoristaRepository.findAll();
    }

    public boolean isPossuiEntregas (Long idMotorista) throws SQLException
    {
        return motoristaRepository.isPossuiEntregas(idMotorista);
    }

    public void delete (Long idMotorista) throws SQLException, EntidadeEmUsoException
    {

        if(isPossuiEntregas(idMotorista))
        {
            throw new EntidadeEmUsoException("-- Entidade em uso ! Impossível remoção --");
        }

        motoristaRepository.delete(idMotorista);
    }

    private void validacaoMotorista (Motorista motorista)
    {
        if(motorista.getNome().isBlank())
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
