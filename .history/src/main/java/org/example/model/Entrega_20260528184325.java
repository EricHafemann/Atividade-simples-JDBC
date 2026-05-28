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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }



}
