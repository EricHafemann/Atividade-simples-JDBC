package org.example.model;

import java.sql.Date;

public class HistoricoEntrega {

    private Long id;
    private Entrega entrega;
    private Date dataEvento;
    private String descricao;
    
    public HistoricoEntrega(Long id, Entrega entrega, Date dataEvento, String descricao) {
        this.id = id;
        this.entrega = entrega;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }

    public HistoricoEntrega(Entrega entrega, Date dataEvento, String descricao) {
        this.entrega = entrega;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }
  

}
