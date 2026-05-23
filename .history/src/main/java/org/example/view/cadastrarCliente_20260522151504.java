package org.example.view;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import org.example.util.Utility;

public class cadastrarCliente {

    public static Util util = new Utility()

    public static void menu() {
        
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
