package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.model.Motorista;
import org.example.model.Pedido;
import org.example.service.MotoristaService;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class CadastrarEntrega {

    private final static Utility util = new Utility();

    public static void menu ()
    {
        System.out.println("\n-- Cadastro de Entrega --\n");

        List<Motorista> motoristas = null;

        MotoristaService motoristaService = new MotoristaService();

        try
        {
            motoristas = motoristaService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        System.out.println("\n\n-- Motoristas Aptos -- \n");

        for(Motorista motorista : motoristas)
        {
            motorista.exibirInfo();
        }

        Long motoristaId = 0l;
        
        System.out.print("\n\nDigite o ID do Motorista escolhido:");

        try
        {
            motoristaId = util.lLong();
        }catch(InputMismatchException e)
        {
            util.cls(5);
            System.err.println("ID Inválido ! Digite um ID correto.");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        PedidoService pedidoService = new PedidoService();

        List<Pedido> pedidos = null;

        try
        {
            pedidos = pedidoService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        System.out.println("\n\n-- Pedidos Aptos -- \n");

        for(Pedido pedido : pedidos)
        {
            pedido.exibirInfo();
        }

        Long pedidoId = 0l;

        try{
            pedidoId = util.lLong();
        }catch(InputMismatchException e)
        {
            util.cls(5);
            System.err.println("ID Inválido ! Digite um ID correto.");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        System.out.println("\nDigite a CNH do motorista: ");
        String cnh = util.lString();

        System.out.println("\nDigite a Cidade Base do motorista: ");
        String cidadeBase = util.lString();

        System.out.println("\nDigite o veículo do motorista: ");
        String veiculo = util.lString();
    }

    public static Pedido 
}
