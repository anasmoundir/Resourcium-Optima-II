package com.example.optima.Services;

import com.example.optima.Dao.WorkerDao;
import com.example.optima.Entities.WorkerEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class WorkerService {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private WorkerDao workerDAO;

    public WorkerService() {
        this.workerDAO = new WorkerDao(entityManagerFactory);
    }

    public List<WorkerEntity> getAllWorkers() {
        return workerDAO.getAllWorkers();
    }

    public WorkerEntity getWorkerById(int id) {
        return workerDAO.getWorkerById(id);
    }

    public void addWorker(WorkerEntity worker) {
        workerDAO.addWorker(worker);
    }

    public void updateWorker(WorkerEntity worker) {
        workerDAO.updateWorker(worker);
    }

    public void deleteWorker(int id) {
        workerDAO.deleteWorker(id);
    }
}
