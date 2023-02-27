package com.example.proyectoapirest.modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "medico", schema = "bd_hospital_api")
public class MedicoClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "medico_cod", nullable = false)
    private int medicoCod;
    @Basic
    @Column(name = "nombre", nullable = true, length = 20)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 30)
    private String apellido;
    @Basic
    @Column(name = "codigo_hospital", insertable = false, updatable = false)
    private int codigoHospital;

    @ManyToOne
    @JoinColumn(name = "codigo_hospital", referencedColumnName = "codigo", nullable = false)
    private HospitalClass hospitalByCodigo;

    public MedicoClass() {
    }

    public MedicoClass(int medicoCod, String nombre, String apellido, int codigoHospital, HospitalClass hospitalByCodigo) {
        this.medicoCod = medicoCod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoHospital = codigoHospital;
        this.hospitalByCodigo = hospitalByCodigo;
    }

    public int getMedicoCod() {
        return medicoCod;
    }

    public void setMedicoCod(int medicoCod) {
        this.medicoCod = medicoCod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoHospital() {
        return codigoHospital;
    }

    public void setCodigoHospital(int codigoHospital) {
        this.codigoHospital = codigoHospital;
    }

    public HospitalClass getHospitalByCodigo() {
        return hospitalByCodigo;
    }

    public void setHospitalByCodigo(HospitalClass hospitalByCodigo) {
        this.hospitalByCodigo = hospitalByCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoClass that = (MedicoClass) o;
        return medicoCod == that.medicoCod && codigoHospital == that.codigoHospital && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicoCod, nombre, apellido, codigoHospital);
    }
}
