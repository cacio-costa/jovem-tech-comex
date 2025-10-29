package br.com.alura.comex.dao;

import br.com.alura.comex.dominio.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaCategoriaDao implements CategoriaDao {

    private final EntityManager entityManager;

    public JpaCategoriaDao(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public List<Categoria> listaTodas() {
        // Java Persistence Query Language (JPQL)
        String jpql = "select c from Categoria c order by c.nome";

        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        return query.getResultList();
    }

    @Override
    public void insere(Categoria categoria) {
        entityManager.persist(categoria);
    }

    @Override
    public void atualiza(Categoria categoria) {
        entityManager.merge(categoria);
    }

    @Override
    public void remove(Long id) {
        Categoria categoriaParaRemocao = buscaPorId(id);
        entityManager.remove(categoriaParaRemocao);
    }

    @Override
    public Categoria buscaPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }
}
