package br.com.alura.comex.sistema;

import br.com.alura.comex.sistema.comando.*;
import br.com.alura.comex.springfake.SpringFake;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aplicacao {
    static Scanner sc = SpringFake.getScanner();

    private static Map<Integer, Funcionalidade> funcionalidades = Map.of(
        2, new ListagemDeCategorias(),
        4, new ExclusaoDeCliente()
    );

    public static void main(String[] args) {

        int escolha = pedeOpcaoDoUsuario();
        while (escolha != 5) {
            Funcionalidade funcionalidadeEscolhida = funcionalidades.getOrDefault(escolha, new OpcaoInvalida());
            funcionalidadeEscolhida.executa();

            escolha = pedeOpcaoDoUsuario();
        }
    }

    public static int pedeOpcaoDoUsuario() {
        System.out.println("# FUNCIONALIDADES:");
        System.out.println("1 - Atualização de categoria");
        System.out.println("2 - Listagem de categorias");
        System.out.println("3 - Inclusão de cliente");
        System.out.println("4 - Exclusão de cliente");
        System.out.println("5 - Sair");

        System.out.println("\nEscolha uma funcionalidade (1-4): ");


        int escolha = sc.nextInt();
        return escolha;
    }

}
