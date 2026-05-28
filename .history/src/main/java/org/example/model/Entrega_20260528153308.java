package org.example.model;

import java.sql.Date;

import org.example.model.enums.StatusEntrega;

public class Entrega {

    private Long id;
    private Pedido pedido;
    private Motorista motorista;
    private Date dataSaida;
    private Date dataEntrega;
    private StatusEntrega statusEntrega;

    public Entrega(Date dataEntrega, Date dataSaida, Long id, Motorista motorista, Pedido pedido, StatusEntrega statusEntrega) {
        this.dataEntrega = dataEntrega;
        this.dataSaida = dataSaida;
        this.id = id;
        this.motorista = motorista;
        this.pedido = pedido;
        this.statusEntrega = statusEntrega;
    }

    public Entrega(Date dataEntrega, Date dataSaida, Motorista motorista, Pedido pedido, StatusEntrega statusEntrega) {
        this.dataEntrega = dataEntrega;
        this.dataSaida = dataSaida;
        this.motorista = motorista;
        this.pedido = pedido;
        this.statusEntrega = statusEntrega;
    }

    

    

}
