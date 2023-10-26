package com.example.optima.Dao;

import com.example.optima.Entities.WorkerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class WorkerDao {
    private EntityManagerFactory entityManagerFactory;

    public WorkerDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<WorkerEntity> getAllWorkers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT w FROM WorkerEntity w";
            TypedQuery<WorkerEntity> query = em.createQuery(jpql, WorkerEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public WorkerEntity getWorkerById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(WorkerEntity.class, id);
        } finally {
            em.close();
        }
    }

    public void addWorker(WorkerEntity worker) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(worker);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void updateWorker(WorkerEntity worker) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(worker);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteWorker(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            WorkerEntity worker = em.find(WorkerEntity.class, id);
            if (worker != null) {
                em.getTransaction().begin();
                em.remove(worker);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }
}