package com.example.optima.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reservation", schema = "resourcium_optima", catalog = "")
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "reservation_date")
    private Date reservationDate;
    @Basic
    @Column(name = "retour_date")
    private Date retourDate;
    @Basic
    @Column(name = "id_equipement")
    private Integer idEquipement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getRetourDate() {
        return retourDate;
    }

    public void setRetourDate(Date retourDate) {
        this.retourDate = retourDate;
    }

    public Integer getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(Integer idEquipement) {
        this.idEquipement = idEquipement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (id != that.id) return false;
        if (reservationDate != null ? !reservationDate.equals(that.reservationDate) : that.reservationDate != null)
            return false;
        if (retourDate != null ? !retourDate.equals(that.retourDate) : that.retourDate != null) return false;
        if (idEquipement != null ? !idEquipement.equals(that.idEquipement) : that.idEquipement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reservationDate != null ? reservationDate.hashCode() : 0);
        result = 31 * result + (retourDate != null ? retourDate.hashCode() : 0);
        result = 31 * result + (idEquipement != null ? idEquipement.hashCode() : 0);
        return result;
    }
}
