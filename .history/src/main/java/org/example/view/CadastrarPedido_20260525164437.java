package org.example.view;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import org.example.Main;
import org.example.exceptions.CnhExistException;
import org.example.model.Cliente;
import org.example.model.Motorista;
import org.example.repository.ClienteRepository;
import org.example.service.ClienteService;
import org.example.service.MotoristaService;
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


        System.out.println("\nDigite o volume do pedido: ");
        String volume = util.lString();

        System.out.println("\nDigite a Cidade Base do motorista: ");
        String cidadeBase = util.lString();

        System.out.println("\nDigite o veículo do motorista: ");
        String veiculo = util.lString();


        // Instancia objeto Motorista que vai ser enviado
        Motorista motoristaRequest = new Motorista(cidadeBase, cnh, veiculo, nome);

        // Motorista que será retornado (Com o Id)
        Motorista motoristaResponse = null;

        // Instancia service onde está concentrada a regra de negócio
        MotoristaService motoristaService = new MotoristaService();

        try
        {
            motoristaResponse = motoristaService.insertMotorista(motoristaRequest);
        }catch(SQLException | CnhExistException | IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }

        if(motoristaResponse != null)
        {
            System.out.println("\n-- Motorista cadastrado com Sucesso ! --");

            motoristaResponse.exibirInfo();
        }

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        util.lString();

        util.cls(5);

        Main.menuPrincipal();
    
    }
    
}
