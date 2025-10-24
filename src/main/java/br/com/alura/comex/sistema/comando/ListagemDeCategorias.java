package br.com.alura.comex.sistema.comando;

import br.com.alura.comex.service.CategoriaService;
import br.com.alura.comex.springfake.SpringFake;

public class ListagemDeCategorias implements Funcionalidade {

    @Override
    public void executa() {
        System.out.println("Listando categorias...");
        CategoriaService categoriaService = SpringFake.getCategoriaService();

        categoriaService.listaTodas()
                .forEach(categoria -> {
                    System.out.println("ID: " + categoria.getId() + " | Nome: " + categoria.getNome() + " | Ativa? " + categoria.getStatus());
                });
    }
}
