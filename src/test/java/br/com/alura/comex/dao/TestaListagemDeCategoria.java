package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Categoria;
import br.com.alura.comex.service.CategoriaService;
import br.com.alura.comex.springfake.SpringFake;

import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategoria {

    public static void main(String[] args) throws SQLException {
        CategoriaService service = SpringFake.getCategoriaService();

        List<Categoria> categorias = service.listaTodas();

        for (Categoria categoria : categorias) {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nome: " + categoria.getNome());
            System.out.println("Status: " + categoria.getStatus());
            System.out.println("========");
        }
    }

}