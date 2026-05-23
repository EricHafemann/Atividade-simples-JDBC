package org.example.view;

import org.example.Main;
import org.example.util.Utility;

public class SairDoSistema {

    static Utility util = new Utility();

    public static void exibir() {

    util.cls(5);

        System.out.println("Saindo do Sistema ");

        for(int i = 0; i < 3; i++)
        {
            System.out.print(".");
        }

        System.out.println();

        Main.menuPrincipal();
    }
}
