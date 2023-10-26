package com.example.optima.Services;

import com.example.optima.Dao.BreakDownDao;
import com.example.optima.Dao.EquipementsDao;
import com.example.optima.Entities.BreakdownEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class BreakDownService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public BreakDownService(EntityManagerFactory entityManagerFactory) {
        this.breakDownDao = new BreakDownDao(entityManagerFactory);
    }

    private BreakDownDao breakDownDao;

    public List<BreakdownEntity> AllBreakDown()
    {
        return breakDownDao.getAllBreakdowns();
    }
}
