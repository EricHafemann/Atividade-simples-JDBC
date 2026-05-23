package org.example.view;

import org.example.Main;
import org.example.util.Utility;

public class SairDoSistema {

    static Utility util = new Utility();

    public static void exibir() {

    util.cls(5);

        System.err.println("Erro ! Opção escolhida não foi encontrada!");

        util.delay(1500);

        

        Main.menuPrincipal();
    }
}
