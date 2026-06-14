package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.Main;
import org.example.service.EntregaService;
import org.example.util.Utility;

public class EntregasAtrasadasPorCidade {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Relatório: Entregas Atrasadas por Cidade --\n\n");

        List<HashMap<String, Integer>> listEntregasAtrasadasPorCidade = new ArrayList<>();

        try 
        {
            EntregaService entregaService = new EntregaService();

            listEntregasAtrasadasPorCidade = entregaService.entregasAtrasadasPorCidade();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
        }

        if(listEntregasAtrasadasPorCidade.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhuma Entrega Atrasada Encontrada ! --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        int contador = 1;

        for(HashMap<String, Integer> entregasAtrasadasPorCidade : listEntregasAtrasadasPorCidade)
        {
            for(HashMap.Entry<String, Integer> entregasAtrasadasPorCidadeMap : entregasAtrasadasPorCidade.entrySet())
            {
                String cidade = entregasAtrasadasPorCidadeMap.getKey();
                int quantidadeEntregas = entregasAtrasadasPorCidadeMap.getValue();
                System.out.println("──────────────────────────────────────────────────────────────────────────");
                System.out.println("[ " + contador + " ] * CIDADE: " + cidade + " || * QUANTIDADE DE ENTREGAS ATRASADAS: " + quantidadeEntregas + "");
                System.out.println("──────────────────────────────────────────────────────────────────────────\n");

                contador ++;
            }
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();
        Main.menuPrincipal();
    }
}