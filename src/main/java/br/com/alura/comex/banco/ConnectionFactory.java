package br.com.alura.comex.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Padrão de Projeto - Factory
 */
public class ConnectionFactory {

    public Connection criaConexao() {
        String url = "jdbc:mysql://localhost:3306/comex";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao obter uma conexão com MySQL.", e);
        }
    }
}
