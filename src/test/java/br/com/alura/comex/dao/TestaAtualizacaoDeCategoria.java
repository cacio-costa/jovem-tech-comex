package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Categoria;

import java.sql.SQLException;

public class TestaAtualizacaoDeCategoria {

    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Automotiva");
        categoria.setStatus("ATIVA");
        categoria.setId(5L);

        CategoriaDao dao = new CategoriaDao();
        dao.atualiza(categoria);

        System.out.println("Categoria atualizada com sucesso!");
    }
}
