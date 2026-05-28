package org.example.model;

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

    
  

}
