package com.example.optima.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "privilege_role", schema = "resourcium_optima")
public class PrivilegeRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "Id_Privilleges")
    private int idPrivilleges;
    @Basic
    @Column(name = "Id_Role")
    private int idRole;

    public int getIdPrivilleges() {
        return idPrivilleges;
    }

    public void setIdPrivilleges(int idPrivilleges) {
        this.idPrivilleges = idPrivilleges;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivilegeRoleEntity that = (PrivilegeRoleEntity) o;

        if (idPrivilleges != that.idPrivilleges) return false;
        if (idRole != that.idRole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPrivilleges;
        result = 31 * result + idRole;
        return result;
    }
}
