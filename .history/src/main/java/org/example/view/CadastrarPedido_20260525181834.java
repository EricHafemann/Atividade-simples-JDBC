package org.example.view;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.example.Main;
import org.example.exceptions.CnhExistException;
import org.example.model.Cliente;
import org.example.model.Motorista;
import org.example.model.Pedido;
import org.example.model.enums.Status_Pedido;
import org.example.service.ClienteService;
import org.example.service.MotoristaService;
import org.example.service.PedidoService;
import org.example.util.Utility;

public class CadastrarPedido {

    static Utility util = new Utility();

    public static void menu () {
        System.out.println("\n-- Cadastro de Pedido --\n");

        List<Cliente> clientes = null;

        try
        {
            ClienteService clienteService = new ClienteService();
            clientes = clienteService.findAll();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("\n-- LISTA DE CLIENTES --");

        for(Cliente cliente : clientes)
        {
            cliente.exibirInfo();
        }

        System.out.println("\n\n");

        System.out.println("\nDigite o ID do cliente para o pedido: ");
        Long id_cliente = util.lLong();

        if(id_cliente <= 0)
        {
            util.cls(5);
            System.err.println("ID Inválido ! Digite um ID correto.");
            util.delay(2000);
            Main.menuPrincipal();
        }

        boolean idExist = false;
        Cliente clientePedido = null;

        for(Cliente cliente: clientes)
        {
            if(cliente.getId() == id_cliente)
            {
                idExist = true;
                clientePedido = cliente;
                break;
            }
        }

        if(!idExist)
        {
            util.cls(5);
            System.err.println("Usuário não encontrado com esse ID.");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\nDigite o volume do pedido em (Metros Cubicos): ");
        double volume = util.lDouble();

        System.out.println("\nDigite o peso do pedido em (KG): ");
        double peso = util.lDouble();

        LocalDate localDate = LocalDate.now();
        Date dateAtual = Date.valueOf(localDate);

        // Instancia objeto Pedido que vai ser enviado
        Pedido pedidoRequest = new Pedido(clientePedido, dateAtual, volume, peso, Status_Pedido.PENDENTE);

        // Pedido que será retornado (Com o Id)
        Pedido pedidoResponse = null;

        // Instancia service onde está concentrada a regra de negócio
        PedidoService pedidoService = new PedidoService();

        try
        {
            pedidoResponse = pedidoService.insertPedido(pedidoRequest);
        }catch(SQLException | CnhExistException | IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }

        if(pedidoResponse != null)
        {
            System.out.println("\n-- Pedido cadastrado com Sucesso ! --");

            pedidoResponse.exibirInfo();
        }

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();

        util.cls(5);

        Main.menuPrincipal();
    
    }
    
}
