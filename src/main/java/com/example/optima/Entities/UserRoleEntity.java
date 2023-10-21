package com.example.optima.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role", schema = "resourcium_optima", catalog = "")
public class UserRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id_Pivote")
    private int idPivote;
    @Basic
    @Column(name = "Id_user")
    private int idUser;
    @Basic
    @Column(name = "Id_Role")
    private int idRole;

    public int getIdPivote() {
        return idPivote;
    }

    public void setIdPivote(int idPivote) {
        this.idPivote = idPivote;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

        UserRoleEntity that = (UserRoleEntity) o;

        if (idPivote != that.idPivote) return false;
        if (idUser != that.idUser) return false;
        if (idRole != that.idRole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPivote;
        result = 31 * result + idUser;
        result = 31 * result + idRole;
        return result;
    }
}
