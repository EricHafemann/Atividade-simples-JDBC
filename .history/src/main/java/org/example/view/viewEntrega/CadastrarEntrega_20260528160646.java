package org.example.view.viewEntrega;

import org.example.util.Utility;

public class CadastrarEntrega {

    private final static Utility util = new Utility();

    public static void menu ()
    {
        System.out.println("\n-- Cadastro de Motorista --\n");

        System.out.println("\nDigite o nome do motorista: ");
        String nome = util.lString();

        System.out.println("\nDigite a CNH do motorista: ");
        String cnh = util.lString();

        System.out.println("\nDigite a Cidade Base do motorista: ");
        String cidadeBase = util.lString();

        System.out.println("\nDigite o veículo do motorista: ");
        String veiculo = util.lString();
    }
}
