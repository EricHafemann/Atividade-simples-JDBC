package org.example.view.viewPedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.model.Pedido;
import org.example.model.enums.StatusPedido;
import org.example.service.PedidoService;
import org.example.util.Utility;
import org.example.view.viewSistema.DefaultMenssage;

public class AtualizarStatusPedido {
    
    public final static Utility util = new Utility();

    public static void exibir () {
        
        System.out.println("\n-- Atualizar Status da Entrega --\n");

        List<Pedido> pedidos = new ArrayList<>();

        try
        {
            PedidoService pedidoService = new PedidoService();
            pedidos = pedidoService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        if(pedidos.isEmpty())
        {
            util.cls(5);
            System.out.println("-- Não há nenhum Pedido registrado ! --");
            util.delay(2000);
            util.cls(20);
        }

        System.out.println("\n -- Lista de Pedidos --\n");

        for(Pedido pedido : pedidos)
        {
            pedido.exibirInfo();
        }

        System.out.println("\nDigite o ID do Pedido escolhido: ");
       

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
        Pedido pedidoEscolhido = null;
        for(Pedido pedido : pedidos)
        {
            if(pedido.getId() == idEscolhido)
            {
                idExists = true;
                pedidoEscolhido = pedido;

                if(pedido.getStatusPedido() == StatusPedido.ENTREGUE)
                {
                    util.cls(5);
                    System.err.println("-- ERRO ! O Pedido desse ID ja foi Entregue --");   
                    util.delay(2000);
                    util.cls(20);
                    Main.menuPrincipal();
                }   

                if(pedido.getStatusPedido() == StatusPedido.CANCELADO)
                {
                    util.cls(5);
                    System.err.println("-- ERRO ! O Pedido desse ID ja foi Cancelado --");   
                    util.delay(2000);
                    util.cls(20);
                    Main.menuPrincipal();
                }  

                break;
            }
        }

        String statusAtual = pedidoEscolhido.getStatusPedido().getDescricao();

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

        System.out.println("[1] - PENDENTE");

        System.out.println("[2] - ENTREGUE");

        System.out.println("[3] - CANCELADO");
        
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
            case 1 -> novoStatus = "PENDENTE";
            case 2 -> novoStatus = "ENTREGUE";
            case 3 -> novoStatus = "CANCELADO";
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

            pedidoEscolhido.setStatusPedido(StatusPedido.fromDescricao(novoStatus));

            try
            {
                PedidoService pedidoService = new PedidoService();
                pedidoService.updatePedido(pedidoEscolhido);
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
