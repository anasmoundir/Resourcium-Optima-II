package com.example.optima.Dao;

import com.example.optima.Entities.BreakdownEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreakDownDaoTest {
    private EntityManagerFactory entityManagerFactory;
    private BreakDownDao breakDownDao;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        breakDownDao = new BreakDownDao(entityManagerFactory);
    }

    @Test
    void testGetAllBreakdowns() {
        // Add test data to the database
        BreakdownEntity breakdown1 = new BreakdownEntity();
        breakdown1.setBreakDownName("Breakdown 1");

        BreakdownEntity breakdown2 = new BreakdownEntity();
        breakdown2.setBreakDownName("Breakdown 2");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(breakdown1);
            em.persist(breakdown2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        // Test the getAllBreakdowns method
        List<BreakdownEntity> breakdowns = breakDownDao.getAllBreakdowns();
        assertEquals(2, breakdowns.size());

        // Clean up: Delete the test data
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            BreakdownEntity retrievedBreakdown1 = em.find(BreakdownEntity.class, breakdown1.getIdBreakDown());
            BreakdownEntity retrievedBreakdown2 = em.find(BreakdownEntity.class, breakdown2.getIdBreakDown());

            if (retrievedBreakdown1 != null) {
                em.remove(retrievedBreakdown1);
            }

            if (retrievedBreakdown2 != null) {
                em.remove(retrievedBreakdown2);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}