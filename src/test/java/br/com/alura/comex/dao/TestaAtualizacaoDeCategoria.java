package br.com.alura.comex.dao;

import br.com.alura.comex.banco.ConnectionFactory;
import br.com.alura.comex.dominio.Categoria;
import br.com.alura.comex.service.CategoriaService;
import br.com.alura.comex.springfake.SpringFake;

public class TestaAtualizacaoDeCategoria {

    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Automotiva");
        categoria.setStatus("ATIVA");
        categoria.setId(5L);

        CategoriaService service = SpringFake.getCategoriaService();
        service.atualiza(categoria);

        System.out.println("Categoria atualizada com sucesso!");
    }
}
