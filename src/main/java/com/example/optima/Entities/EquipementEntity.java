    package com.example.optima.Entities;

    import jakarta.persistence.*;
    import org.hibernate.annotations.Cascade;

    @Entity
    @Table(name = "equipement", schema = "resourcium_optima", catalog = "")
    public class EquipementEntity {
        @ManyToOne
        @JoinColumn(name = "Id_Break_Down", referencedColumnName = "Id_Break_Down", insertable = false, updatable = false)
        private BreakdownEntity breakdown;
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "Id_Equipement")
        private int idEquipement;
        @Basic
        @Column(name = "Equipment_code")
        private String equipmentCode;
        @Basic
        @Column(name = "Availability")
        private byte availability;
        @Basic
        @Column(name = "Id_Break_Down")
        private int idBreakDown;
        @Basic
        @Column(name = "Id_Departement")
        private int idDepartement;

        public int getIdEquipement() {
            return idEquipement;
        }

        public void setIdEquipement(int idEquipement) {
            this.idEquipement = idEquipement;
        }

        public String getEquipmentCode() {
            return equipmentCode;
        }

        public void setEquipmentCode(String equipmentCode) {
            this.equipmentCode = equipmentCode;
        }

        public byte getAvailability() {
            return availability;
        }

        public void setAvailability(byte availability) {
            this.availability = availability;
        }

        public int getIdBreakDown() {
            return idBreakDown;
        }

        public void setIdBreakDown(int idBreakDown) {
            this.idBreakDown = idBreakDown;
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

            EquipementEntity that = (EquipementEntity) o;

            if (idEquipement != that.idEquipement) return false;
            if (availability != that.availability) return false;
            if (idBreakDown != that.idBreakDown) return false;
            if (idDepartement != that.idDepartement) return false;
            if (equipmentCode != null ? !equipmentCode.equals(that.equipmentCode) : that.equipmentCode != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = idEquipement;
            result = 31 * result + (equipmentCode != null ? equipmentCode.hashCode() : 0);
            result = 31 * result + (int) availability;
            result = 31 * result + idBreakDown;
            result = 31 * result + idDepartement;
            return result;
        }
    }
