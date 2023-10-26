package com.example.optima.Services;


import com.example.optima.Dao.EquipementsDao;
import com.example.optima.Entities.EquipementEntity;
import jakarta.persistence.*;
import java.util.List;

public class EquipementsService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EquipementsDao equipmentDao;
    public EquipementsService() {
        this.equipmentDao = new EquipementsDao(entityManagerFactory);
    }

    public List<EquipementEntity> getAllEquipment() {

            return equipmentDao.getAllEquipment();
          }

    public EquipementEntity  getEquipmentById(int equipmentId) {
        return equipmentDao.getEquipmentById(equipmentId);
    }

    public void addEquipment(EquipementEntity equipment, int departmentId) {

        equipmentDao.addEquipment(equipment, departmentId);
    }

    public void updateEquipment(EquipementEntity equipment) {
        equipmentDao.updateEquipment(equipment);
    }

    public void deleteEquipment(int equipmentId) {
        equipmentDao.deleteEquipment(equipmentId);
    }
}
