package com.example.proyectoapirest.modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "enfermera", schema = "bd_hospital_api")
public class EnfermeraClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "enfermera_cod", nullable = false)
    private int enfermeraCod;
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

    public EnfermeraClass() {
    }

    public EnfermeraClass(int enfermeraCod, String nombre, String apellido, int codigoHospital, HospitalClass hospitalByCodigo) {
        this.enfermeraCod = enfermeraCod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoHospital = codigoHospital;
        this.hospitalByCodigo = hospitalByCodigo;
    }

    public int getEnfermeraCod() {
        return enfermeraCod;
    }

    public void setEnfermeraCod(int enfermeraCod) {
        this.enfermeraCod = enfermeraCod;
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
        EnfermeraClass that = (EnfermeraClass) o;
        return enfermeraCod == that.enfermeraCod && codigoHospital == that.codigoHospital && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enfermeraCod, nombre, apellido, codigoHospital);
    }
}
