package org.example.model;

import java.sql.Date;

import org.example.model.enums.Status_Pedido;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private Date data_pedido;
    private double volume_m3;
    private double peso_kg;
    private Status_Pedido statusPedido;

    public Pedido(Long id, Cliente cliente, Date data_pedido, double volume_m3, double peso_kg,
            Status_Pedido statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.statusPedido = statusPedido;
    }

    public Pedido(Cliente cliente, Date data_pedido, double volume_m3, double peso_kg,
            Status_Pedido statusPedido) {
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.statusPedido = statusPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public double getVolume_m3() {
        return volume_m3;
    }

    public void setVolume_m3(double volume_m3) {
        this.volume_m3 = volume_m3;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public Status_Pedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Status_Pedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    pu
}
