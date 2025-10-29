package br.com.alura.comex.springfake;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.banco.JPAUtil;
import br.com.alura.comex.dao.JdbcCategoriaDao;
import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.dao.JpaCategoriaDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.service.CategoriaService;
import br.com.alura.comex.service.ClienteService;
import jakarta.persistence.EntityManager;

import java.sql.Connection;
import java.util.Scanner;

public class SpringFake {

    private static final Scanner sc = new Scanner(System.in);

    public static CategoriaService getCategoriaService() {;
//        Connection conexao = new ConnectionFactory().criaConexao();
//        JdbcCategoriaDao jdbcCategoriaDao = new JdbcCategoriaDao(conexao);

        EntityManager entityManager = JPAUtil.criaEntityManager();
        JpaCategoriaDao jpaCategoriaDao = new JpaCategoriaDao(entityManager);

        CategoriaService service = new CategoriaService(jpaCategoriaDao);
        return service;
    }

    public static ClienteService getClienteService() {
        Connection conexao = new ConnectionFactory().criaConexao();

        var clienteDao = new ClienteDao(conexao);
        var pedidoDao = new PedidoDao(conexao);

        ClienteService service = new ClienteService(clienteDao, pedidoDao);
        return service;
    }

    public static Scanner getScanner() {
        return sc;
    }
}
