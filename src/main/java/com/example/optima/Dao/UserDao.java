package com.example.optima.Dao;

import com.example.optima.Entities.RoleEntity;
import com.example.optima.Entities.UserEntity;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;
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

    public List<UserEntity> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
    public void updateUserRole(int userId, Set<RoleEntity> roles) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserEntity user = entityManager.find(UserEntity.class, userId); // Find the user by ID
            if (user != null && roles != null && !roles.isEmpty()) {
                user.setRoles(roles);
            }
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
    public RoleEntity getRoleById(int roleId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager(); // Define EntityManager
        try {
            TypedQuery<RoleEntity> query = entityManager.createQuery(
                    "SELECT r FROM RoleEntity r WHERE r.id = :roleId",
                    RoleEntity.class
            );
            query.setParameter("roleId", roleId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }


    public List<UserEntity> getAllUsersWithRoles() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery("SELECT DISTINCT u FROM UserEntity u LEFT JOIN FETCH u.roles", UserEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
}
