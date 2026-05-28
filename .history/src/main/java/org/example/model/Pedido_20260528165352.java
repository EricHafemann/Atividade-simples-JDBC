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

    public Pedido(Long id, Date data_pedido, Cliente cliente, double volume, double peso,
            StatusPedido statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume = volume;
        this.peso = peso;
        this.statusPedido = statusPedido;
    }

                    id,
                    data_pedido,
                    volume_m3,
                    peso_kg,
                    status

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

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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
        System.out.println("= Peso(KG):    "+getPeso());
        System.out.println("= Volume(m3):  "+getVolume());
        System.out.println("= Status:      "+getStatusPedido().getDescricao());
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
}
