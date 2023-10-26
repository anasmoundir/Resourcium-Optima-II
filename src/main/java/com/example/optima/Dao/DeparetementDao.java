package com.example.optima.Dao;

import com.example.optima.Entities.DepartmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DeparetementDao {
    private EntityManagerFactory entityManagerFactory;
    public DeparetementDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public List<DepartmentEntity> getAllDepartments() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT d FROM DepartmentEntity d";
            TypedQuery<DepartmentEntity> query = em.createQuery(jpql, DepartmentEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
