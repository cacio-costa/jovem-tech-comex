package br.com.alura.comex.service;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.dao.PedidoDao;
import br.com.alura.comex.dominio.Cliente;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteService {

    public boolean excluiCliente(Cliente clienteParaExcluir) {
        try (Connection conexao = new ConnectionFactory().criaConexao()) {

            PedidoDao pedidoDao = new PedidoDao();
            pedidoDao.setConexao(conexao);

            if (pedidoDao.temPedidoDoCliente(clienteParaExcluir)) {
                return false;
            } else {
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.setConexao(conexao);

                clienteDao.exclui(clienteParaExcluir);

                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
