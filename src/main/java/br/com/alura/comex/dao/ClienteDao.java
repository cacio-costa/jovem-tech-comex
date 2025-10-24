package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Cliente;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements Transacionavel {

    private Connection conexao;

    public ClienteDao(Connection conexao) {
        this.conexao = conexao;
    }

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

    public void atualiza(Cliente cliente) {
        String sql = """
                     update cliente
                        set nome = ?,
                            cpf = ?,
                            telefone = ?,
                            endereco = ?,
                            cidade = ?,
                            estado = ?
                      where id = ?""";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getEndereco());
            comando.setString(5, cliente.getCidade());
            comando.setString(6, cliente.getEstado());
            comando.setLong(7, cliente.getId());

            comando.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao atualizar cliente.", e);
        }
    }

    public List<Cliente> listaTodos() {
        String sql = "select * from cliente order by nome";

        try (PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultSet = comando.executeQuery()) {

            List<Cliente> lista = new ArrayList<>();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setEstado(resultSet.getString("estado"));

                lista.add(cliente);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao listar clientes.", e);
        }
    }

    public Cliente buscaPorId(Long id) {
        String sql = "select * from cliente where id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setLong(1, id);

            try (ResultSet resultSet = comando.executeQuery()) {
                if (resultSet.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(resultSet.getLong("id"));
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setCpf(resultSet.getString("cpf"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                    cliente.setEndereco(resultSet.getString("endereco"));
                    cliente.setCidade(resultSet.getString("cidade"));
                    cliente.setEstado(resultSet.getString("estado"));
                    return cliente;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao buscar cliente por id.", e);
        }
    }

    public void abreTransacao() {
        try {
            conexao.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void efetivaTransacao() {
        try {
            conexao.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
