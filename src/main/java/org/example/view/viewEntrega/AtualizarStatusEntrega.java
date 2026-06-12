package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.model.Entrega;
import org.example.model.enums.StatusEntrega;
import org.example.service.EntregaService;
import org.example.util.Utility;
import org.example.view.viewSistema.DefaultMenssage;

public class AtualizarStatusEntrega {
    
    public final static Utility util = new Utility();

    public static void exibir () {
        
        System.out.println("\n-- Atualizar Status da Entrega --\n");

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
            util.cls(5);
            System.out.println("-- Não há nenhuma Entrega registrada ! --");
            util.delay(2000);
            util.cls(20);
        }

        System.out.println("\n -- Lista das Entregas --\n");

        for(Entrega entrega : entregas)
        {
            entrega.exibirInfo();
        }

        System.out.println("\nDigite o ID da entrega escolhida: ");
       

        Long idEscolhido = 0L;

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

                if(entrega.getStatusEntrega() == StatusEntrega.ENTREGUE)
                {
                    util.cls(5);
                    System.err.println("-- ERRO ! A entrega desse ID ja foi Entregue --");   
                    util.delay(2000);
                    util.cls(20);
                    Main.menuPrincipal();
                }   

                break;
            }
        }

        String statusAtual = entregaEscolhida.getStatusEntrega().getDescricao();

        if(!idExists)
        {
            util.cls(5);
            System.err.println("ID escolhido não existe !");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\n= = = = = = = = = = = = = = = = = = = = = =");
        System.out.println("    Para qual STATUS você deseja alterar ?");
        System.out.println("  --   STATUS ATUAL:  ["+statusAtual+"]   --");
        System.out.println("= = = = = = = = = = = = = = = = = = = = = =\n");

        System.out.println("[1] - EM ROTA");

        System.out.println("[2] - ENTREGUE");

        System.out.println("[3] - ATRASADA");
        
        System.out.println("\nEscolha uma opção: ");

        int opcaoStatus = 0;

        try
        {
            opcaoStatus = util.lInt();
        }catch(InputMismatchException e)
        {
            util.cls(3);
            System.err.println("-- Opção Inválida ! Digite apenas números --");
            util.delay(2000);
            util.cls(20);
            Main.menuPrincipal();
        }

        String novoStatus = null;

        switch (opcaoStatus) {
            case 1 -> novoStatus = "EM_ROTA";
            case 2 -> novoStatus = "ENTREGUE";
            case 3 -> novoStatus = "ATRASADA";
            default -> DefaultMenssage.exibir();
        }

        if(statusAtual.equals(novoStatus))
        {
            util.cls(5);
            System.err.println("-- ERRO ! O Status não pode ser o mesmo do atual --");
            util.delay(2000);
            util.cls(20);
            Main.menuPrincipal();
        }

        else
        {

            entregaEscolhida.setStatusEntrega(StatusEntrega.fromDescricao(novoStatus));

            try
            {
                EntregaService entregaService = new EntregaService();
                entregaService.updateEntrega(entregaEscolhida);
            }catch(SQLException e)
            {
                util.cls(5);
                System.err.println(e.getMessage());
                util.cls(20);
                Main.menuPrincipal();
            }

            System.out.println("\n-- Status Atualizado com Sucesso ! --");
            util.delay(2000);
            util.cls(20);

            Main.menuPrincipal();
        }

    }
}
