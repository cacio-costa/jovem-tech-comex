package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Categoria;

import java.sql.*;
import java.util.List;

public class TestaListagemDeCategoria {

    public static void main(String[] args) throws SQLException {
        CategoriaDao dao = new CategoriaDao();
        List<Categoria> categorias = dao.listaTodas();

        for (Categoria categoria : categorias) {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nome: " + categoria.getNome());
            System.out.println("Status: " + categoria.getStatus());
            System.out.println("========");
        }
    }

}