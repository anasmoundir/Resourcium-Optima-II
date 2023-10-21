package com.example.optima.Dao;

import com.example.optima.Entities.RoleEntity;
import com.example.optima.Entities.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.Set;

public class UserDao {
    private final EntityManagerFactory entityManagerFactory;


    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }
    public void save(UserEntity user, Set<RoleEntity> roles) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (roles != null && !roles.isEmpty()) {
                user.setRoles(roles);
            }

            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }



    public UserEntity getUserByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }


}
