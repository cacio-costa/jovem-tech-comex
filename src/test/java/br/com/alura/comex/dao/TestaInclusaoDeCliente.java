package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Cliente;
import br.com.alura.comex.service.ClienteService;
import br.com.alura.comex.springfake.SpringFake;

public class TestaInclusaoDeCliente {

    public static void main(String[] args) {
        // 'Ana Silva', '98765432100', '(21) 99876-5432', 'Rua B, 456', 'Rio de Janeiro', 'RJ'
        Cliente cliente = new Cliente();
        cliente.setNome("Ana Silva");
        cliente.setCpf("98765432100");
        cliente.setTelefone("(21) 99876-5432");
        cliente.setEndereco("Rua B, 456");
        cliente.setCidade("Rio de Janeiro");
        cliente.setEstado("RJ");

        ClienteService clienteService = SpringFake.getClienteService();
        clienteService.insere(cliente);

        System.out.println("Cliente cadastrado com sucesso");
    }
}
