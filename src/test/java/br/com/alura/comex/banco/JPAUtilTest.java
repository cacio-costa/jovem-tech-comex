package br.com.alura.comex.banco;

import jakarta.persistence.EntityManager;

public class JPAUtilTest {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.criaEntityManager();
        System.out.println("EntityManager criado com sucesso: " + entityManager);

        entityManager.close();
    }
}
