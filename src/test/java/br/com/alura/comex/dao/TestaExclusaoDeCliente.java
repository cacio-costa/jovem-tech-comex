package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Cliente;
import br.com.alura.comex.service.ClienteService;
import br.com.alura.comex.springfake.SpringFake;


public class TestaExclusaoDeCliente {

    public static void main(String[] args) {
        Cliente clienteParaExcluir = new Cliente();
        clienteParaExcluir.setId(11L);


        ClienteService clienteService = SpringFake.getClienteService();
        boolean sucesso = clienteService.excluiCliente(clienteParaExcluir);

        if (sucesso) {
            System.out.println("Cliente excluido com sucesso!");
        } else {
            System.out.println("Exclusão não realizada! Há pedidos vinculados ao cliente.");
        }
    }
}
