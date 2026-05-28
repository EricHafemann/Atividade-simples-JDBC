package org.example;

import java.util.InputMismatchException;

import org.example.util.Utility;
import org.example.view.DefaultMenssage;
import org.example.view.SairDoSistema;
import org.example.view.viewCliente.CadastrarCliente;
import org.example.view.viewEntrega.GerarEntrega;
import org.example.view.viewMotorista.CadastrarMotorista;
import org.example.view.viewPedido.CadastrarPedido;

public class Main {

    private final static Utility util = new Utility();
    
    public static void main(String[] args) {
     menuPrincipal();
    }

    public static void menuPrincipal() {
        
        int op = 0;

        System.out.println("""
            ╔══════════════════════════════════════════════════════╗
            ║           SISTEMA DE LOGÍSTICA DE ENTREGAS           ║
            ╚══════════════════════════════════════════════════════╝
            """);

        listarOpcoes();

          try
        {
            op = util.lInt();
            switchCase(op);
        }catch(InputMismatchException e)
        {
            util.cls(2);
            System.err.println("""
                Erro!
            Digite apenas números válidos.
            """);
            util.delay(1500);
        }
    }


    private  static void switchCase (int op) {
        switch(op)
        {
            case 0 -> SairDoSistema.exibir();
            case 1 -> CadastrarCliente.menu();
            case 2 -> CadastrarMotorista.menu();
            case 3 -> CadastrarPedido.menu();
            case 4 -> CadastrarEntrega.menu();
            default -> DefaultMenssage.exibir();
        }
    }

    private static void listarOpcoes() {

    System.out.println("""
    ┌──────────────── CADASTROS ────────────────┐
    │  1  - Cadastrar Cliente                   │
    │  2  - Cadastrar Motorista                 │
    └───────────────────────────────────────────┘

    ┌──────────────── PEDIDOS ──────────────────┐
    │  3  - Criar Pedido                        │
    │  4  - Gerar Entrega                       │
    │  5  - Registrar Evento                    │
    │  6  - Atualizar Status                    │
    │  7  - Listar Entregas                     │
    └───────────────────────────────────────────┘

    ┌──────────────── RELATÓRIOS ───────────────┐
    │  8  - Total de Entregas por Motorista     │
    │  9  - Clientes com Maior Volume           │
    │ 10  - Pedidos Pendentes por Estado        │
    │ 11  - Entregas Atrasadas por Cidade       │
    └───────────────────────────────────────────┘

    ┌──────────────── CONSULTAS ────────────────┐
    │ 12  - Buscar Pedido por CPF/CNPJ          │
    └───────────────────────────────────────────┘

    ┌──────────────── EXCLUSÕES ────────────────┐
    │ 13  - Cancelar Pedido                     │
    │ 14  - Excluir Entrega                     │
    │ 15  - Excluir Cliente                     │
    │ 16  - Excluir Motorista                   │
    └───────────────────────────────────────────┘

    ┌──────────────── SISTEMA ──────────────────┐
    │  0  - Sair                                │
    └───────────────────────────────────────────┘
""");
}
}