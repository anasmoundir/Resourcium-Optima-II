package com.example.optima.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "breakdown", schema = "resourcium_optima", catalog = "")
public class BreakdownEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Break_Down")
    private int idBreakDown;
    @Basic
    @Column(name = "Break_Down_name")
    private String breakDownName;
    @Basic
    @Column(name = "Break_down_time")
    private Date breakDownTime;

    public int getIdBreakDown() {
        return idBreakDown;
    }

    public void setIdBreakDown(int idBreakDown) {
        this.idBreakDown = idBreakDown;
    }

    public String getBreakDownName() {
        return breakDownName;
    }

    public void setBreakDownName(String breakDownName) {
        this.breakDownName = breakDownName;
    }

    public Date getBreakDownTime() {
        return breakDownTime;
    }

    public void setBreakDownTime(Date breakDownTime) {
        this.breakDownTime = breakDownTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BreakdownEntity that = (BreakdownEntity) o;

        if (idBreakDown != that.idBreakDown) return false;
        if (breakDownName != null ? !breakDownName.equals(that.breakDownName) : that.breakDownName != null)
            return false;
        if (breakDownTime != null ? !breakDownTime.equals(that.breakDownTime) : that.breakDownTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBreakDown;
        result = 31 * result + (breakDownName != null ? breakDownName.hashCode() : 0);
        result = 31 * result + (breakDownTime != null ? breakDownTime.hashCode() : 0);
        return result;
    }
}
