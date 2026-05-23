package org.example.view;

import org.example.util.Utility;

public class DefaultMenssage {

    static Utility util = new Utility();
    
    public static void exibir() {

        System.err.println("Erro ! Opção escolhida não foi encontrada!");

        util.delay(1500);

        Main.menuPrincipal();
    }
}
