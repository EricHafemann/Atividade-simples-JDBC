package org.example.view;

import org.example.Main;

public class SairDoSistema {

    public static void exibir() {

        System.err.println("Erro ! Opção escolhida não foi encontrada!");

        util.delay(1500);

        util.cls(5);

        Main.menuPrincipal();
    }
}
