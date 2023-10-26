package com.example.optima.Dao;

import com.example.optima.Entities.DepartmentEntity;
import com.example.optima.Entities.EquipementEntity;
import jakarta.persistence.*;


import java.util.List;

public class EquipementsDao {


    private EntityManagerFactory entityManagerFactory;
    public EquipementsDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public  List<EquipementEntity> getAllEquipment() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT e FROM EquipementEntity e";
            TypedQuery<EquipementEntity> query = em.createQuery(jpql, EquipementEntity.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public EquipementEntity getEquipmentById(int equipmentId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(EquipementEntity.class, equipmentId);
        } finally {
            em.close();
        }    }

    public void addEquipment(EquipementEntity equipment, int departmentId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            equipment.setIdDepartement(departmentId);
            em.merge(equipment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void updateEquipment(EquipementEntity equipment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(equipment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void deleteEquipment(int equipmentId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            EquipementEntity equipment = em.find(EquipementEntity.class, equipmentId);
            if (equipment != null) {
                em.remove(equipment);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }


}
