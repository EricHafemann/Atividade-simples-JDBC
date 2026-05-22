package org.example.model;

import org.example.model.enums.Status_Entrega;

public class HistoricoEntrega {

    private Long id;
    private Pedido pedido;
    private Motorista motorista;
    private Date data_saida;
    private Date data_entrada;
    private Status_Entrega statusEntrega;
    
    public HistoricoEntrega(Long id, Pedido pedido, Motorista motorista, Date data_saida, Date data_entrada,
            Status_Entrega statusEntrega) {
        this.id = id;
        this.pedido = pedido;
        this.motorista = motorista;
        this.data_saida = data_saida;
        this.data_entrada = data_entrada;
        this.statusEntrega = statusEntrega;
    }

    
}
