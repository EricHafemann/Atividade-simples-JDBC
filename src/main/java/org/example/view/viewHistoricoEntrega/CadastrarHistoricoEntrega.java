package org.example.view.viewHistoricoEntrega;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.model.Entrega;
import org.example.model.HistoricoEntrega;
import org.example.service.EntregaService;
import org.example.service.HistoricoEntregaService;
import org.example.util.Utility;

public class CadastrarHistoricoEntrega {
    
    static Utility util = new Utility();

    public static void exibir ()
    {
        System.out.println("\n-- Registrar Evento de Entrega --\n");

        List<Entrega> entregas = new ArrayList<>();

        try
        {
            EntregaService entregaService = new EntregaService();
            entregas = entregaService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        if(entregas.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Não há Entregas Cadastradas --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        for(Entrega entrega : entregas)
        {
            entrega.exibirInfo();
        }

        Long idEscolhido = 0L;

        System.out.println("\nDigite o ID da Entrega desejada: ");

        try
        {
            idEscolhido = util.lLong();
        }catch(InputMismatchException e)
        {
            util.cls(5);
            System.err.println("ID Inválido ! Digite um ID correto.");
            util.delay(2000);
            Main.menuPrincipal();
        }

        boolean idExists = false;
        Entrega entregaEscolhida = null;

        for(Entrega entrega : entregas)
        {
            if(entrega.getId() == idEscolhido)
            {
                idExists = true;
                entregaEscolhida = entrega;
                break;
            }
        }

        if(!idExists)
        {
            util.cls(5);
            System.err.println("ID escolhido não existe !");
            util.delay(2000);
            Main.menuPrincipal();
        }

        // Formato da Data 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\nDigite a data do Evento: (Dia/Mês/Ano)");
        String dataEventoString = util.lString();

        LocalDate dataEventoLocal = LocalDate.parse(dataEventoString, formato);
        Date dataEvento = Date.valueOf(dataEventoLocal);

        System.out.println("\nDigite uma descrição para o Evento: ");
        String descricao = util.lString();

        HistoricoEntrega historicoEntregaRequest = new HistoricoEntrega(entregaEscolhida, dataEvento, descricao);

        HistoricoEntrega historicoEntregaResponse = null;
        try
        {
            HistoricoEntregaService historicoEntregaService = new HistoricoEntregaService();
            historicoEntregaResponse = historicoEntregaService.insertHistoricoEntrega(historicoEntregaRequest);
        }catch(SQLException | IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }

        if(historicoEntregaResponse != null)
        {
            System.out.println("\n-- Historico de Entrega registrado com Sucesso ! --");

            historicoEntregaRequest.exibirInfo();
        }

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();

        util.cls(5);

        Main.menuPrincipal();
    }
}
