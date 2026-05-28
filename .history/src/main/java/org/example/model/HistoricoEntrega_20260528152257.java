package org.example.model;

import java.sql.Date;

import org.example.model.enums.Status_Entrega;

public class HistoricoEntrega {

    private Long id;
    private Pedido pedido;
    private Motorista motorista;
    private Date dataSaida;
    private Date data_entrada;
    private Status_Entrega statusEntrega;
    
    public HistoricoEntrega(Long id, Pedido pedido, Motorista motorista, Date dataSaida, Date data_entrada,
            Status_Entrega statusEntrega) {
        this.id = id;
        this.pedido = pedido;
        this.motorista = motorista;
        this.dataSaida = dataSaida;
        this.data_entrada = data_entrada;
        this.statusEntrega = statusEntrega;
    }

    public HistoricoEntrega(Pedido pedido, Motorista motorista, Date data_saida, Date data_entrada,
            Status_Entrega statusEntrega) {
        this.pedido = pedido;
        this.motorista = motorista;
        this.data_saida = data_saida;
        this.data_entrada = data_entrada;
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

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.dataSaida = data_saida;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Status_Entrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(Status_Entrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }


}
