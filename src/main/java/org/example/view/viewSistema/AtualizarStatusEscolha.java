package org.example.view.viewSistema;

import java.util.InputMismatchException;

import org.example.Main;
import org.example.util.Utility;
import org.example.view.viewEntrega.AtualizarStatusEntrega;
import org.example.view.viewPedido.AtualizarStatusPedido;

public class AtualizarStatusEscolha {
    
    public static final Utility util = new Utility();

    public static void exibir ()
    {
        util.cls(10);
        System.out.println("+-+-++-+-++-+-++-+-++-+-++-+-++-+-+");
        System.out.println("Deseja atualizar o STATUS de qual ?");
        System.out.println("+-+-++-+-++-+-++-+-++-+-++-+-++-+-+\n");

        System.out.println("[1] - Atualizar Status do Pedido");
    
        System.out.println("[2] - Atualizar Status da Entrega");

        System.out.println("[3] - Voltar ao Menu Principal");

        int opcaoEscolhida = 0;
        
        try
        {
            opcaoEscolhida = util.lInt();
        }catch(InputMismatchException e)
        {
            util.lString();
            System.err.println(e.getMessage());
        }

        switch (opcaoEscolhida) {
            case 1 -> AtualizarStatusPedido.exibir();
            case 2 -> AtualizarStatusEntrega.exibir();
            case 3 -> Main.menuPrincipal();
            default -> DefaultMenssage.exibir();
        }
       
    }
}
