package org.example;

import java.util.InputMismatchException;

import org.example.util.Utility;

public class Main {

    private final static Utility util = new Utility();
    
    public static void main(String[] args) {
     menuPrincipal();
    }

    private static void menuPrincipal() {
        
        int op = 0;

        listarOpcoes();

        try
        {
            op = util.lInt();
        }catch(InputMismatchException e)
        {
            System.err.println();
        }

        

        

    }

    public static void listarOpcoes () {
        System.out.println("""
                1 - Cadastrar Cliente
                2 - Cadastrar Motorista
                3 - Criar Pedido
                4 - Atribuir Pedido a Motorista (Gerar Entrega)
                5 - Registrar Evento de Entrega (Histórico)
                6 - Atualizar Status da Entrega
                7 - Listar Todas as Entregas com Cliente e Motorista
                8 - Relatório: Total de Entregas por Motorista
                9 - Relatório: Clientes com Maior Volume Entregue
                10 - Relatório: Pedidos Pendentes por Estado
                11 - Relatório: Entregas Atrasadas por Cidade
                12 - Buscar Pedido por CPF/CNPJ do Cliente
                13 - Cancelar Pedido
                14 - Excluir Entrega (com validação)
                15 - Excluir Cliente (com verificação de dependência)
                16 - Excluir Motorista (com verificação de dependência)
                0 - Sair
                """);
    }
}