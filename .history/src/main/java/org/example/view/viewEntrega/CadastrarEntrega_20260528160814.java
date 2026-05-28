package org.example.view.viewEntrega;

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

        System.out.println("\nDigite a CNH do motorista: ");
        String cnh = util.lString();

        System.out.println("\nDigite a Cidade Base do motorista: ");
        String cidadeBase = util.lString();

        System.out.println("\nDigite o veículo do motorista: ");
        String veiculo = util.lString();
    }
}
