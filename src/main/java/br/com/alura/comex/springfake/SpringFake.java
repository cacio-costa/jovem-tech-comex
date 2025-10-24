package br.com.alura.comex.springfake;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dao.CategoriaDao;
import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.service.CategoriaService;
import br.com.alura.comex.service.ClienteService;

import java.sql.Connection;

public class SpringFake {

    public static CategoriaService getCategoriaService() {;
        Connection conexao = new ConnectionFactory().criaConexao();
        CategoriaDao categoriaDao = new CategoriaDao(conexao);

        CategoriaService service = new CategoriaService(categoriaDao);
        return service;
    }

    public static ClienteService getClienteService() {
        Connection conexao = new ConnectionFactory().criaConexao();

        var clienteDao = new ClienteDao(conexao);
        var pedidoDao = new PedidoDao(conexao);

        ClienteService service = new ClienteService(clienteDao, pedidoDao);
        return service;
    }
}
