package org.example.view.viewPedido;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.Main;
import org.example.model.Pedido;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class BuscarPedidoPorCpfCnpj {

    private static final Utility util = new Utility();
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibir()
    {
        System.out.println("\n-- Buscar Pedido por CPF/CNPJ do Cliente --\n\n");
        
        System.out.print("Digite o CPF ou CNPJ do cliente: ");
        String documento = scanner.nextLine().trim();
        
        if(documento.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Documento não informado! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        List<Pedido> listPedidos = new ArrayList<>();
        
        try 
        {
            PedidoService pedidoService = new PedidoService();
            listPedidos = pedidoService.buscarPedidoPorDocumento(documento);
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        if(listPedidos.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum pedido encontrado para o documento: " + documento + " ! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        
        for(Pedido pedido : listPedidos)
        {
            pedido.exibirInfo();
            System.out.println();
        }
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
        
        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();
        Main.menuPrincipal();
    }
}