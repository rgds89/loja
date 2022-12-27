package br.com.alura.loja.config;

import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class EntityManagerConfig {

    public EntityManager openTrasaction(){
        return JPAUtil.getEntityManager();
    }

    public void getTrasaction(EntityManager em){
        em.getTransaction().begin();
    }

    public void commitTransaction(EntityManager em){
        em.getTransaction().commit();
    }

    public void closeTransaction(EntityManager em){
        em.close();
    }
}
