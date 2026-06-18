package org.example.view.viewCliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.exceptions.EntidadeEmUsoException;
import org.example.model.Cliente;
import org.example.service.ClienteService;
import org.example.util.Utility;

public class DeletarCliente {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Deletar Cliente --\n\n");

        List<Cliente> clientes = new ArrayList<>();

        try
        {
            ClienteService clienteService = new ClienteService();
            clientes = clienteService.findAll();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
            Main.menuPrincipal();
        }

        if(clientes.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum cliente registrado --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");

        for(Cliente cliente : clientes)
        {
            cliente.exibirInfo();
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");
        }

        System.out.print("\nDigite o ID do cliente que deseja deletar: ");
        Long idCliente = 0L;
        
        try {
            idCliente = util.lLong();
        } catch(InputMismatchException e) {
            util.cls(3);
            System.err.println("-- ID inválido! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        Cliente clienteEncontrado = null;
        for(Cliente cliente : clientes) {
            if(cliente.getId().equals(idCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        
        if(clienteEncontrado == null) {
            util.cls(3);
            System.err.println("-- Cliente não encontrado! --");
            util.delay(2000);
            Main.menuPrincipal();
            return;
        }

        System.out.println("\n────────────────────────────────────────────────────────────────");
        System.out.println("Cliente encontrado:");
        clienteEncontrado.exibirInfo();
        System.out.println("────────────────────────────────────────────────────────────────");
        
        System.out.print("\nDeseja realmente deletar este cliente? (S/N): ");
        String confirmacao = util.lString();
        
        if(confirmacao.equalsIgnoreCase("S")) {
            try {
                ClienteService clienteService = new ClienteService();
                clienteService.delete(idCliente);
                util.cls(3);
                System.out.println("-- Cliente deletado com sucesso! --");
                util.delay(2000);
            } catch(SQLException | EntidadeEmUsoException e) {
                util.cls(3);
                System.err.println(e.getMessage());
                util.delay(2000);
            }
        } else {
            util.cls(3);
            System.out.println("-- Deleção abortada! --");
            util.delay(2000);
        }
        
        Main.menuPrincipal();
    }
}