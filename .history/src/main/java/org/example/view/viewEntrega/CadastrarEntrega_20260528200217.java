package org.example.view.viewEntrega;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.model.Entrega;
import org.example.model.Motorista;
import org.example.model.Pedido;
import org.example.model.enums.StatusEntrega;
import org.example.service.EntregaService;
import org.example.service.MotoristaService;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class CadastrarEntrega {

    private final static Utility util = new Utility();

    public static void menu ()
    {
        System.out.println("\n-- Cadastro de Entrega --\n");
    
        Motorista motorista = solicitarMotorista();

        Pedido pedido = solicitarPedido();

        System.out.println("Digite a data de Saída da Entrega: (Ano/Dia/Mês)");
        String dataSaidaString = util.lString();

        Date dataSaida = Date.valueOf(dataSaidaString);

        System.out.println("Digite a data de Recebimento da Entrega: (Ano/Dia/Mês)");
        String dataEntregaString = util.lString();

        Date dataEntrega = Date.valueOf(dataEntregaString);

        EntregaService entregaService = new EntregaService();

        Entrega entregaRequest = new Entrega(pedido,motorista,dataSaida,dataEntrega,StatusEntrega.EM_ROTA);

        Entrega entregaResponse = null;

        try
        {
           entregaResponse = entregaService.insertEntrega(entregaRequest); 
        }catch(SQLException e)
        {
            util.cls(5);
            System.err.println(e.getMessage());
            util.delay(1500);
            Main.menuPrincipal();
        }
        
        if(entregaResponse != null)
        {
            System.out.println("\n-- Entrega cadastrado com Sucesso ! --");

            entregaResponse.exibirInfo();
        }
        
        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();

        util.cls(5);

        Main.menuPrincipal();

    }
        
    

    public static Pedido solicitarPedido ()
    {
        PedidoService pedidoService = new PedidoService();

        List<Pedido> pedidos = new ArrayList<>();

        try
        {
            pedidos = pedidoService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        if(pedidos.isEmpty())
        {
             util.cls(3);
            System.err.println("-- Não há Pedidos Cadastrados --");
            util.delay(2000);
            Main.menuPrincipal();
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

        boolean valido = false;
        Pedido pedidoEscolhido = null;

        for(Pedido pedido : pedidos)
        {
            if(pedido.getId() == pedidoId)
            {
                valido = true;
                pedidoEscolhido = pedido;
                break;
            }
        }

        if(!valido)
        {
            util.cls(5);
            System.err.println("--ID Pedido é inválido !--");
            util.delay(1500);
        }

        return pedidoEscolhido;


    }

    public static Motorista solicitarMotorista ()
    {
        List<Motorista> motoristas = new ArrayList<>();

        MotoristaService motoristaService = new MotoristaService();

        try
        {
            motoristas = motoristaService.findAll();
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        if(motoristas.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Não há Motorista Cadastrados --");
            util.delay(2000);
            Main.menuPrincipal();
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

        boolean valido = false;
        Motorista motoristaEscolhido = null;

        for(Motorista motorista : motoristas)
        {
            if(motorista.getId() == motoristaId)
            {
                valido = true;
                motoristaEscolhido = motorista;
                break;
            }
        }

        if(!valido)
        {
            util.cls(5);
            System.err.println("--ID do Motorista é inválido !--");
            util.delay(1500);
        }

        return motoristaEscolhido;
    }

}
