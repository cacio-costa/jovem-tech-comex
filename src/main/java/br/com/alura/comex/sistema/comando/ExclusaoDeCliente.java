package br.com.alura.comex.sistema.comando;

import br.com.alura.comex.service.ClienteService;
import br.com.alura.comex.springfake.SpringFake;

import java.util.Scanner;

public class ExclusaoDeCliente implements Funcionalidade {

    @Override
    public void executa() {
        System.out.println("### EXCLUSÃO DE CLIENTE ###\n");

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        System.out.println("Informe o ID do cliente a ser excluído: ");
        long id = scanner.nextLong();

        ClienteService clienteService = SpringFake.getClienteService();

        var cliente = clienteService.buscaPorId(id);
        if (cliente == null) {
            System.out.println("Cliente com ID " + id + " não encontrado.");
            return;
        }

        clienteService.excluiCliente(cliente);
        System.out.println("Cliente excluído com sucesso!");
        System.out.println("Digite uma tecla para voltar ao menu...");
    }
}
