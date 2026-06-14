package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.Main;
import org.example.service.EntregaService;
import org.example.util.Utility;

public class ClientesComMaisEntregasConcluidas {

    private static final Utility  util = new Utility();

    public static void exibir ()
    {
        System.out.println("\n-- Clientes com Maior Volume Entregue --\n\n");

        List<HashMap<String, Integer>> listRankEntregaByClientes = new ArrayList<>();

        try 
        {
            EntregaService entregaService = new EntregaService();

            listRankEntregaByClientes = entregaService.rankEntregaByClientes();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
        }

        if(listRankEntregaByClientes.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum Cliente Cadastrado em uma Entrega  ! --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        int contador = 1;

        for(HashMap<String, Integer> rankEntregaByClientes : listRankEntregaByClientes)
        {
            for(HashMap.Entry<String, Integer> rankEntregaByClientesMap : rankEntregaByClientes.entrySet())
            {
                String nome = rankEntregaByClientesMap.getKey();
                int quantidadeEntregas = rankEntregaByClientesMap.getValue();
                System.out.println("────────────────────────────────────────────────────────────────");
                System.out.println("[ " + contador + " ] * CLIENTE: " + nome+ " || * QUANTIDADE DE ENTREGA: " + quantidadeEntregas+"");
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
    

