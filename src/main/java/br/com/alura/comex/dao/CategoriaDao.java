package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Categoria;

import java.util.List;

public interface CategoriaDao {
    List<Categoria> listaTodas();

    void insere(Categoria categoria);

    void atualiza(Categoria categoria);

    void remove(Long id);

    Categoria buscaPorId(Long id);
}
