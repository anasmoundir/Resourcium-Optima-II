package com.example.optima.Dao;

import com.example.optima.Entities.EquipementEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EquipementsDaoTest {
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
    void getAllEquipment() {
        EquipementsDao equipementsDao = new EquipementsDao(entityManagerFactory);
        List<EquipementEntity>  listEquipement = equipementsDao.getAllEquipment();
        assertNotNull(listEquipement);
    }

    @Test
    void getEquipmentById() {
        EquipementsDao equipementsDao = new EquipementsDao(entityManagerFactory);
        int existingId = 8;
        EquipementEntity equipement = equipementsDao.getEquipmentById(existingId);
        assertNotNull(equipement);
        assertEquals(existingId,equipement.getIdEquipement());
    }

    @Test
    void addEquipment() {
        EquipementEntity equipement = new EquipementEntity();

        equipement.setIdBreakDown(1);
        equipement.setEquipmentCode("test   equipement  ");
        equipement.setAvailability((byte) 0);
        equipement.setIdEquipement(100);
        EquipementsDao equipementsDao = new EquipementsDao(entityManagerFactory);
        assertDoesNotThrow(() -> {
            equipementsDao.addEquipment(equipement, 2);
        });
    }

    @Test
    void updateEquipment() {
        EquipementEntity equipement = new EquipementEntity();
        equipement.setIdEquipement(8);
        equipement.setEquipmentCode("Updated Equipment");
        equipement.setAvailability((byte) 1);
        equipement.setIdBreakDown(1);
        equipement.setIdDepartement(2);
        EquipementsDao equipementsDao = new EquipementsDao(entityManagerFactory);

        String originalEquipmentCode = equipementsDao.getEquipmentById(8).getEquipmentCode();
        byte originalAvailability = equipementsDao.getEquipmentById(8).getAvailability();

        equipementsDao.updateEquipment(equipement);

        EquipementEntity updatedEquipment = equipementsDao.getEquipmentById(8);

        assertEquals("Updated Equipment", updatedEquipment.getEquipmentCode());
        assertEquals((byte) 1, updatedEquipment.getAvailability());

        updatedEquipment.setEquipmentCode(originalEquipmentCode);
        updatedEquipment.setAvailability(originalAvailability);
        equipementsDao.updateEquipment(updatedEquipment);
    }
    @Test
    public void getEquipementById() {
        EquipementsDao equipementsDao = new EquipementsDao(entityManagerFactory);
        int nonExistingId = 100;
        EquipementEntity equipement = equipementsDao.getEquipmentById(nonExistingId);
        assertNull(equipement);
    }

    @Test
    void deleteEquipment() {
        int equipmentId = 8;
        EquipementsDao dao = new EquipementsDao(entityManagerFactory);
        assertDoesNotThrow(() -> dao.deleteEquipment(equipmentId));
    }
}