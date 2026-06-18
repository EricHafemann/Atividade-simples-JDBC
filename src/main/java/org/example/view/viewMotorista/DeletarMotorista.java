package org.example.view.viewMotorista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.example.Main;
import org.example.exceptions.EntidadeEmUsoException;
import org.example.model.Motorista;
import org.example.service.MotoristaService;
import org.example.util.Utility;

public class DeletarMotorista {

    private static final Utility util = new Utility();

    public static void exibir()
    {
        System.out.println("\n-- Deletar Motorista --\n\n");

        List<Motorista> motoristas = new ArrayList<>();

        try
        {
            MotoristaService motoristaService = new MotoristaService();
            motoristas = motoristaService.findAll();
        }catch(SQLException e)
        {
            util.cls(3);
            System.err.println(e.getMessage());
            util.delay(2000);
            Main.menuPrincipal();
        }

        if(motoristas.isEmpty())
        {
            util.cls(3);
            System.err.println("-- Nenhum motorista registrado --");
            util.delay(2000);
            Main.menuPrincipal();
        }

        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");

        for(Motorista motorista : motoristas)
        {
            motorista.exibirInfo();
            System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - ");
        }

        System.out.print("\nDigite o ID do motorista que deseja deletar: ");
        Long idMotorista = 0L;
        
        try {
            idMotorista = util.lLong();
        } catch(InputMismatchException e) {
            util.cls(3);
            System.err.println("-- ID inválido! --");
            util.delay(2000);
            Main.menuPrincipal();
        }
        
        Motorista motoristaEncontrado = null;
        for(Motorista motorista : motoristas) {
            if(motorista.getId().equals(idMotorista)) {
                motoristaEncontrado = motorista;
                break;
            }
        }
        
        if(motoristaEncontrado == null) {
            util.cls(3);
            System.err.println("-- Motorista não encontrado! --");
            util.delay(2000);
            Main.menuPrincipal();
            return;
        }

        System.out.println("\n────────────────────────────────────────────────────────────────");
        System.out.println("Motorista encontrado:");
        motoristaEncontrado.exibirInfo();
        System.out.println("────────────────────────────────────────────────────────────────");
        
        System.out.print("\nDeseja realmente deletar este motorista? (S/N): ");
        String confirmacao = util.lString();
        
        if(confirmacao.equalsIgnoreCase("S")) {
            try {
                MotoristaService motoristaService = new MotoristaService();
                motoristaService.delete(idMotorista);
                util.cls(3);
                System.out.println("-- Motorista deletado com sucesso! --");
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