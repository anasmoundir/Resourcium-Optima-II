package com.example.optima.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "privilege", schema = "resourcium_optima", catalog = "")
public class PrivilegeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Privilleges")
    private int idPrivilleges;
    @Basic
    @Column(name = "Full_Privilleges")
    private Byte fullPrivilleges;
    @Basic
    @Column(name = "Medium_Privilleges")
    private Byte mediumPrivilleges;

    public int getIdPrivilleges() {
        return idPrivilleges;
    }

    public void setIdPrivilleges(int idPrivilleges) {
        this.idPrivilleges = idPrivilleges;
    }

    public Byte getFullPrivilleges() {
        return fullPrivilleges;
    }

    public void setFullPrivilleges(Byte fullPrivilleges) {
        this.fullPrivilleges = fullPrivilleges;
    }

    public Byte getMediumPrivilleges() {
        return mediumPrivilleges;
    }

    public void setMediumPrivilleges(Byte mediumPrivilleges) {
        this.mediumPrivilleges = mediumPrivilleges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivilegeEntity that = (PrivilegeEntity) o;

        if (idPrivilleges != that.idPrivilleges) return false;
        if (fullPrivilleges != null ? !fullPrivilleges.equals(that.fullPrivilleges) : that.fullPrivilleges != null)
            return false;
        if (mediumPrivilleges != null ? !mediumPrivilleges.equals(that.mediumPrivilleges) : that.mediumPrivilleges != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPrivilleges;
        result = 31 * result + (fullPrivilleges != null ? fullPrivilleges.hashCode() : 0);
        result = 31 * result + (mediumPrivilleges != null ? mediumPrivilleges.hashCode() : 0);
        return result;
    }
}
