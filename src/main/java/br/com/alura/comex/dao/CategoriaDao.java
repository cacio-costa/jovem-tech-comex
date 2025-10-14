package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    public List<Categoria> listaTodas() {
        String sql = "select * from categoria order by nome";

        ConnectionFactory cf = new ConnectionFactory();
        try (Connection conexao = cf.criaConexao();
             PreparedStatement comando = conexao.prepareStatement(sql);
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

    public void atualiza(Categoria categoria) {
        String sql = """
                     update categoria
                        set nome = ?,
                            status = ?
                      where id = ?""";

        try (Connection conexao = new ConnectionFactory().criaConexao();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, categoria.getNome());
            comando.setString(2, categoria.getStatus());
            comando.setLong(3, categoria.getId());
            comando.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao atualizar categoria.", ex);
        }
    }
}
