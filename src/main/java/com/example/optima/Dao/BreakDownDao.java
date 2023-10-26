package com.example.optima.Dao;

import com.example.optima.Entities.BreakdownEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BreakDownDao {
    private EntityManagerFactory entityManagerFactory;
    public BreakDownDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public List<BreakdownEntity> getAllBreakdowns() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT b FROM BreakdownEntity b";
            TypedQuery<BreakdownEntity> query = em.createQuery(jpql, BreakdownEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
