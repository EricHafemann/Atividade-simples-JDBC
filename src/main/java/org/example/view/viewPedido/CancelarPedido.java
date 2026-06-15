package org.example.view.viewPedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.example.Main;
import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class CancelarPedido {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Cancelar Pedido --\n\n");

        List<Pedido> pedidos = new ArrayList<>();

        try
        {
            PedidoService pedidoService = new PedidoService();
            pedidos = pedidoService.findAll();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
            Main.menuPrincipal();
        }

        if(pedidos.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum pedido registrado --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");

        for(Pedido pedido : pedidos)
        {
            pedido.exibirInfo();

            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");
        }


        System.out.print("\nDigite o ID do pedido que deseja cancelar: ");
        Long idPedido = 0L;
        
        try {
            idPedido = util.lLong();
        } catch(InputMismatchException e) {
            util.cls(3);
            System.err.println("-- ID inválido! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        try 
        {
            PedidoService pedidoService = new PedidoService();
            Pedido pedido = pedidoService.findById(idPedido);
            
            if(pedido == null) {
                util.cls(3);
                System.err.println("-- Pedido não encontrado! --");
                util.delay(2000);
                Main.menuPrincipal();
                return;
            }

             if(pedido.getStatusPedido() == StatusPedido.CANCELADO) {
                util.cls(3);
                System.err.println("-- Pedido já foi cancelado !--");
                util.delay(2000);
                Main.menuPrincipal();
                return;
            }

            System.out.println("\n────────────────────────────────────────────────────────────────");
            System.out.println("Pedido encontrado:");
            pedido.exibirInfo();
            System.out.println("────────────────────────────────────────────────────────────────");
            
            System.out.print("\nDeseja realmente cancelar este pedido? (S/N): ");
            String confirmacao = util.lString();
            
            if(confirmacao.equalsIgnoreCase("S")) {
                pedidoService.atualizarStatus(idPedido, StatusPedido.CANCELADO);
                util.cls(3);
                System.out.println("-- Pedido cancelado com sucesso! --");
                util.delay(2000);
            } else {
                util.cls(3);
                System.out.println("-- Cancelamento abortado! --");
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