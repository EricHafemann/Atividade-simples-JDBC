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

public class ExcluirEntrega {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Excluir Entrega --\n\n");

        List<Entrega> entregas = new ArrayList<>();

        try
        {
            EntregaService entregaService = new EntregaService();
            entregas = entregaService.findAll();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
            Main.menuPrincipal();
        }

        if(entregas.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhuma entrega registrada --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");

        for(Entrega entrega : entregas)
        {
            entrega.exibirInfo();
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");
        }

        System.out.print("\nDigite o ID da entrega que deseja excluir: ");
        Long idEntrega = 0L;
        
        try {
            idEntrega = util.lLong();
        } catch(InputMismatchException e) {
            util.cls(3);
            System.err.println("-- ID inválido! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        try 
        {
            EntregaService entregaService = new EntregaService();
            Entrega entrega = entregaService.findById(idEntrega);
            
            if(entrega == null) {
                util.cls(3);
                System.err.println("-- Entrega não encontrada! --");
                util.delay(2000);
                Main.menuPrincipal();
                return;
            }

            // Só pode excluir entregas se não foi ENTREGUE
            if(entrega.getStatusEntrega() == StatusEntrega.ENTREGUE) {
                util.cls(3);
                System.err.println("-- Não é possível excluir esta entrega! Status atual: " + entrega.getStatusEntrega().getDescricao() + " --");
                util.delay(2000);
                Main.menuPrincipal();
                return;
            }

            System.out.println("\n────────────────────────────────────────────────────────────────");
            System.out.println("Entrega encontrada:");
            entrega.exibirInfo();
            System.out.println("────────────────────────────────────────────────────────────────");
            
            System.out.print("\nDeseja realmente excluir esta entrega? (S/N): ");
            String confirmacao = util.lString();
            
            if(confirmacao.equalsIgnoreCase("S")) {
                entregaService.delete(idEntrega);
                util.cls(3);
                System.out.println("-- Entrega excluída com sucesso! --");
                util.delay(2000);
            } else {
                util.cls(3);
                System.out.println("-- Exclusão abortada! --");
                util.delay(2000);
            }
            
        } catch(SQLException e) {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
        }
        
        Main.menuPrincipal();
    }
}