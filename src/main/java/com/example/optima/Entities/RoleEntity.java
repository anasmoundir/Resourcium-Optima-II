package com.example.optima.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "role", schema = "resourcium_optima", catalog = "")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Role")
    private int idRole;
    @Basic
    @Column(name = "Name_Role")
    private String nameRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (idRole != that.idRole) return false;
        if (nameRole != null ? !nameRole.equals(that.nameRole) : that.nameRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }
}
