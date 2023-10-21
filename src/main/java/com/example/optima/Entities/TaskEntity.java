package com.example.optima.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "task", schema = "resourcium_optima", catalog = "")
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Task")
    private int idTask;
    @Basic
    @Column(name = "Beginning_Date")
    private Date beginningDate;
    @Basic
    @Column(name = "Ending_Date")
    private Date endingDate;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (idTask != that.idTask) return false;
        if (beginningDate != null ? !beginningDate.equals(that.beginningDate) : that.beginningDate != null)
            return false;
        if (endingDate != null ? !endingDate.equals(that.endingDate) : that.endingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTask;
        result = 31 * result + (beginningDate != null ? beginningDate.hashCode() : 0);
        result = 31 * result + (endingDate != null ? endingDate.hashCode() : 0);
        return result;
    }
}
