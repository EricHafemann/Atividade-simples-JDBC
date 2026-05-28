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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
  

}
