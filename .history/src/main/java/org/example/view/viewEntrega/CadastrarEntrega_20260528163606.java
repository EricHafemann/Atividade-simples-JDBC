package org.example.view.viewEntrega;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Motorista;
import org.example.service.MotoristaService;
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
            System.err.println(e.getMessage());;
        }

        System.out.println("\n\n-- Motoristas Aptos -- \n");

        for(Motorista motorista : motoristas)
        {
            motorista.exibirInfo();
        }

        System.out.println("\n\n");

        System.out.println("\nDigite a CNH do motorista: ");
        String cnh = util.lString();

        System.out.println("\nDigite a Cidade Base do motorista: ");
        String cidadeBase = util.lString();

        System.out.println("\nDigite o veículo do motorista: ");
        String veiculo = util.lString();
    }
}
