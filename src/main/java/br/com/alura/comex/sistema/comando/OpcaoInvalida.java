package br.com.alura.comex.sistema.comando;

import java.util.Scanner;

public class OpcaoInvalida implements Funcionalidade {

    @Override
    public void executa() {
        System.out.println("Opção inválida!");

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        System.out.println("Digite uma tecla para voltar ao menu...");
        scanner.next();
    }
}
