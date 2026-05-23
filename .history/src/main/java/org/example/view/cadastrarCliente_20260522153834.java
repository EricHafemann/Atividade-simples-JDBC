package org.example.view;

import org.example.util.Utility;

public class CadastrarCliente {

    static Utility util = new Utility();

    public static void menu () {
        System.out.println("\n-- Cadastro de Cliente --\n");

        System.out.println("\nDigite o nome do cliente: ");
        String nome = util.lString();

        System.out.println("\nDigite o CPF ou CNPJ do cliente: ");
        String cpf_cnpj = util.lString();

        System.out.println("\nDigite o endereço do cliente: ");
        String endereco = util.lString();

        System.out.println("\nDigite a cidade do cliente: ");
        String cidade = util.lString();

        System.out.println("\nDigite o estado do cliente: ");
        String estado = util.lString();
    }
}
