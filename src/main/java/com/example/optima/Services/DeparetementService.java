package com.example.optima.Services;

import com.example.optima.Dao.DeparetementDao;
import com.example.optima.Entities.DepartmentEntity;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class DeparetementService {
    private DeparetementDao deparetementDao;

    public DeparetementService(EntityManagerFactory entityManagerFactory) {
        this.deparetementDao = new DeparetementDao(entityManagerFactory);
    }

    public List<DepartmentEntity>  AllDepartements()
    {
        return deparetementDao.getAllDepartments();
    }
}
