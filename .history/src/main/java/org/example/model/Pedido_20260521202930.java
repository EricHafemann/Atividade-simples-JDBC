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

    public Pedido(Long id, Cliente cliente, Date data_pedido, double volume_m3, double peso_kg,
            Status_Pedido statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.statusPedido = statusPedido;
    }

    
}
