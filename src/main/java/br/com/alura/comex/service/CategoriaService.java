// Java
package br.com.alura.comex.service;

import br.com.alura.comex.dao.CategoriaDao;
import br.com.alura.comex.dominio.Categoria;

import java.util.List;
import java.util.Objects;

public class CategoriaService {

    private CategoriaDao categoriaDao;

    public CategoriaService(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public List<Categoria> listaTodas() {
        return categoriaDao.listaTodas();
    }

    public void insere(Categoria categoria) {
        validarNome(categoria);
        categoriaDao.insere(categoria);
    }

    public void atualiza(Categoria categoria) {
        if (categoria == null || categoria.getId() == null || categoria.getId() <= 0) {
            throw new IllegalArgumentException("Id da categoria inválido para atualização.");
        }

        validarNome(categoria);
        categoriaDao.atualiza(categoria);
    }

    public void remove(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id inválido para remoção.");
        }

        categoriaDao.remove(id);
    }

    public Categoria buscaPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id inválido para busca.");
        }

        return categoriaDao.buscaPorId(id);
    }

    private void validarNome(Categoria categoria) {
        if (categoria == null || categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório.");
        }
    }
}