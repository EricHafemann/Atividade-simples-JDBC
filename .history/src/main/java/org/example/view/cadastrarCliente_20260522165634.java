package org.example.view;

import java.sql.SQLException;

import org.example.exceptions.CpfExistException;
import org.example.model.Cliente;
import org.example.service.ClienteService;
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

        // Instancia objeto Usuário que vai ser enviado
        Cliente clienteRequest = new Cliente(nome, cpf_cnpj, endereco, cidade, estado);

        // Cliente que ira ser recebido (Com o Id)
        Cliente clienteResponse = null;

        // Instancia service onde está concentrada a regra de negócio
        ClienteService clienteService = new ClienteService();

        try
        {
            clienteResponse= clienteService.insertCliente(clienteRequest);
        }catch(SQLException | CpfExistException | IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        if(clienteResponse != null)
        {
            System.out.println("\n-- Cliente cadastrado com Sucesso ! --");

            clienteResponse.exibirInfo();
        }

        System.out.println("\nAperte ENTER para voltar ao menu ...");
        
    }
}
