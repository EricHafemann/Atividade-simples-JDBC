package org.example.model;

import java.sql.Date;

import org.example.model.enums.Status_Pedido;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private Date data_pedido;
    private double volume_m3;
    private double peso_kg;
    private Status_Pedido statusPedido
}
