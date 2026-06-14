package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.example.Main;
import org.example.service.EntregaService;
import org.example.util.Utility;

public class EntregasPorMotorista {

    private final static Utility util = new Utility();
    

    public static void exibir ()
    {

        System.out.println("\n-- Entregas por Motorista --\n\n");

        List<HashMap<String, Integer>> listCountEntregasByMotoristas = new ArrayList<>();

        try 
        {
            EntregaService entregaService = new EntregaService();

            listCountEntregasByMotoristas = entregaService.countEntregasByMotoristas();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
        }

        if(listCountEntregasByMotoristas.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum Motorista Cadastrado  ! --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        for(HashMap<String, Integer> registroMotorista : listCountEntregasByMotoristas)
        {
            for(HashMap.Entry<String, Integer> mapRegistroMotorista : registroMotorista.entrySet())
            {
                String nome = mapRegistroMotorista.getKey();
                int quantidadeEntregas = mapRegistroMotorista.getValue();
                System.out.println("────────────────────────────────────────────────────────────────");
                System.out.println(" + MOTORISTA: " + nome+ " || + QUANTIDADE DE ENTREGA: " + quantidadeEntregas+"");
                System.out.println("────────────────────────────────────────────────────────────────\n");
            }
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();
        Main.menuPrincipal();
    }
}
