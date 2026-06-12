package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.Main;
import org.example.model.Entrega;
import org.example.service.EntregaService;
import org.example.util.Utility;

public class ListarEntregas {
    
    public final static Utility util = new Utility();

    public static void exibir() {
        
        System.out.println("\n-- Cadastro de Entrega --\n");

        List<Entrega> entregas = new ArrayList<>();

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - \n");

        try
        {
            EntregaService entregaService = new EntregaService();
            entregas = entregaService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        for(Entrega entrega : entregas)
        {
            entrega.exibirInfo();

            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - \n");
        }

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();

        Main.menuPrincipal();
    }
}
