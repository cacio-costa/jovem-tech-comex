package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Cliente;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {

    private Connection conexao;

    public void exclui(Cliente cliente) {
        String sql = "delete from cliente where id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, cliente.getId());
            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao executar comando para excluir cliente.", e);
        }
    }

    public void insere(Cliente cliente) {
        String sql = """
                     insert into cliente
                        (nome, cpf, telefone, endereco, cidade, estado)
                     values
                        (?, ?, ?, ?, ?, ?)""";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getEndereco());
            comando.setString(5, cliente.getCidade());
            comando.setString(6, cliente.getEstado());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao inserir novo cliente.", e);
        }
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
}
