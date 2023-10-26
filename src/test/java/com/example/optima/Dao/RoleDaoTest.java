package com.example.optima.Dao;

import com.example.optima.Entities.RoleEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {
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
    void findRoleByName() {
        RoleDao roleDao = new RoleDao(entityManagerFactory);
        String roleName = "Admin";

        RoleEntity result = roleDao.findRoleByName(roleName);

        assertNotNull(result);
        assertEquals(roleName, result.getNameRole());

    }
}