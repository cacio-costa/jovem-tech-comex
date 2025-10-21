package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Cliente;

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

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.insere(cliente); // finalizar a lógica de inclusão no banco...

        System.out.println("Cliente cadastrado com sucesso");
    }
}
