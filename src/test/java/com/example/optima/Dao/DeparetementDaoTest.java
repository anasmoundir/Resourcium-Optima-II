package com.example.optima.Dao;

import com.example.optima.Entities.DepartmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DeparetementDaoTest {

    private EntityManagerFactory entityManagerFactory;
    @BeforeEach
    void setup() {
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/Resourcium_Optima");
        properties.put("javax.persistence.jdbc.user", "root");
        properties.put("javax.persistence.jdbc.password", "");

        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    @Test
    void testGetAllDepartments() {
        // Add test data to the database
        DepartmentEntity department1 = new DepartmentEntity();
        department1.setName("Department 1");

        DepartmentEntity department2 = new DepartmentEntity();
        department2.setName("Department 2");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(department1);
            em.persist(department2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        DeparetementDao deparetementDao = new DeparetementDao(entityManagerFactory);
        // Test the getAllDepartments method
        List<DepartmentEntity> departments = deparetementDao.getAllDepartments();
        assertEquals(2, departments.size());

        // Clean up: Delete the test data
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            DepartmentEntity retrievedDepartment1 = em.find(DepartmentEntity.class, department1.getIdDepartement());
            DepartmentEntity retrievedDepartment2 = em.find(DepartmentEntity.class, department2.getIdDepartement());

            if (retrievedDepartment1 != null) {
                em.remove(retrievedDepartment1);
            }

            if (retrievedDepartment2 != null) {
                em.remove(retrievedDepartment2);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}