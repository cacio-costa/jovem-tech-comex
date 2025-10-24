package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private Connection conexao;

    public CategoriaDao(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Categoria> listaTodas() {
        String sql = "select * from categoria order by nome";

        ConnectionFactory cf = new ConnectionFactory();
        try (PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultSet = comando.executeQuery()) {

            List<Categoria> lista = new ArrayList<>();
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getLong("id"));
                categoria.setNome(resultSet.getString("nome"));
                categoria.setStatus(resultSet.getString("status"));

                lista.add(categoria);
            }

            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Falha ao listar categorias.", e);
        }
    }

    public void insere(Categoria categoria) {
        String sql = "insert into categoria (nome, status) values (?, ?)";

        try (PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, categoria.getNome());
            comando.setString(2, categoria.getStatus());
            comando.executeUpdate();

            try (ResultSet generatedKeys = comando.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao salvar categoria.", ex);
        }
    }

    public void atualiza(Categoria categoria) {
        String sql = """
                     update categoria
                        set nome = ?,
                            status = ?
                      where id = ?""";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, categoria.getNome());
            comando.setString(2, categoria.getStatus());
            comando.setLong(3, categoria.getId());
            comando.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar categoria.", ex);
        }
    }

    public void remove(Long id) {
        String sql = "delete from categoria where id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, id);
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao remover categoria.", ex);
        }
    }

    public Categoria buscaPorId(Long id) {
        String sql = "select * from categoria where id = ?";

        try (PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setLong(1, id);
            try (ResultSet resultSet = comando.executeQuery()) {
                if (resultSet.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId(resultSet.getLong("id"));
                    categoria.setNome(resultSet.getString("nome"));
                    categoria.setStatus(resultSet.getString("status"));
                    return categoria;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao buscar categoria por id.", ex);
        }
    }
}