package br.com.alura.comex.banco;

import java.sql.Connection;

public class ConnectionFactoryTest {

    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();

        try (Connection conexao = cf.criaConexao()) {
            System.out.println("Conectado com sucesso!");
            // usar a conexão...
        }  catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
