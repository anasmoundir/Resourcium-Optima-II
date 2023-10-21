package com.example.optima.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "worker", schema = "resourcium_optima", catalog = "")
public class WorkerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Worker")
    private int idWorker;
    @Basic
    @Column(name = "Availability")
    private byte availability;
    @Basic
    @Column(name = "Max_Hours")
    private int maxHours;
    @Basic
    @Column(name = "Id_Task")
    private int idTask;
    @Basic
    @Column(name = "Id_Departement")
    private int idDepartement;

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public byte getAvailability() {
        return availability;
    }

    public void setAvailability(byte availability) {
        this.availability = availability;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkerEntity that = (WorkerEntity) o;

        if (idWorker != that.idWorker) return false;
        if (availability != that.availability) return false;
        if (maxHours != that.maxHours) return false;
        if (idTask != that.idTask) return false;
        if (idDepartement != that.idDepartement) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorker;
        result = 31 * result + (int) availability;
        result = 31 * result + maxHours;
        result = 31 * result + idTask;
        result = 31 * result + idDepartement;
        return result;
    }
}
