package org.example.view.viewPedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.Main;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class PedidosPendentesPorEstado {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Pedidos Pendentes por Estado --\n\n");

        List<HashMap<String, Integer>> listPedidosPendentesPorEstado = new ArrayList<>();

        try 
        {
            PedidoService pedidoService = new PedidoService();

            listPedidosPendentesPorEstado = pedidoService.pedidosPendentesPorEstado();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
        }

        if(listPedidosPendentesPorEstado.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum Pedido Pendente Encontrado ! --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        int contador = 1;

        for(HashMap<String, Integer> pedidosPendentesPorEstado : listPedidosPendentesPorEstado)
        {
            for(HashMap.Entry<String, Integer> pedidosPendentesPorEstadoMap : pedidosPendentesPorEstado.entrySet())
            {
                String estado = pedidosPendentesPorEstadoMap.getKey();
                int quantidadePedidos = pedidosPendentesPorEstadoMap.getValue();
                System.out.println("────────────────────────────────────────────────────────────────");
                System.out.println("[ " + contador + " ] * ESTADO: " + estado + " || * QUANTIDADE DE PEDIDOS PENDENTES: " + quantidadePedidos + "");
                System.out.println("────────────────────────────────────────────────────────────────\n");

                contador ++;
            }
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();
        Main.menuPrincipal();
    }
}