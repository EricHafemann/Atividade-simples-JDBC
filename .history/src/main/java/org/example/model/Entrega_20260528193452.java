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

    

    public Entrega(Long id, Pedido pedido, Motorista motorista, Date dataSaida, Date dataEntrega,
            StatusEntrega statusEntrega) {
        this.id = id;
        this.pedido = pedido;
        this.motorista = motorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
    }

    public Entrega(Pedido pedido, Motorista motorista, Date dataSaida, Date dataEntrega, StatusEntrega statusEntrega) {
        this.pedido = pedido;
        this.motorista = motorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
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

    public void exibirInfo ()
    {
        System.out.println("+-+ Informações da Entrega +-=");
        System.out.println("= ID:          "+getId());
        System.out.println("= Motorista:     "+getMotorista().getNome());
        System.out.println("= ID Pedido:    "+getPedido().getId());
        System.out.println("= Data Saida:  "+getDataSaida());
        System.out.println("= Data Entrega:      "+getStatusPedido().getDescricao());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }

}
