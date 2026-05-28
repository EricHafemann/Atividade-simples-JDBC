package org.example.model;

import java.sql.Date;

import org.example.model.enums.StatusPedido;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private Date data_pedido;
    private double volume;
    private double peso;
    private StatusPedido statusPedido;

    public Pedido(Long id, Cliente cliente, Date data_pedido, double volume, double peso,
            StatusPedido statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume = volume;
        this.peso = peso;
        this.statusPedido = statusPedido;
    }

    public Pedido(Cliente cliente, Date data_pedido, double volume, double peso,
            StatusPedido statusPedido) {
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume = volume;
        this.peso = peso;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume_m3(double volume) {
        this.volume = volume;
    }

    public double getPeso_kg() {
        return peso;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso = peso_kg;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void exibirInfo ()
    {
        System.out.println("+-+ Informações do Pedido +-=");
        System.out.println("= ID:          "+getId());
        System.out.println("= Cliente:     "+getCliente().getNome());
        System.out.println("= Peso(KG):    "+getPeso_kg());
        System.out.println("= Volume(m3):  "+getVolume_m3());
        System.out.println("= Status:      "+getStatusPedido().getDescricao());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
}
