package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDao {

    private Connection conexao;

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public boolean temPedidoDoCliente(Cliente cliente) {
        String sql = "select count(*) quantidade from pedido where cliente_id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, cliente.getId());

            try (ResultSet resultado = comando.executeQuery()) {
                resultado.next();

                Long quantidadeDePedidos = resultado.getLong("quantidade");
                return quantidadeDePedidos > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao consultar quantidade de pedidos de um cliente.", e);
        }
    }
}
