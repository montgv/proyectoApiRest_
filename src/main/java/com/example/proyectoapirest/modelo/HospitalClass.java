package com.example.proyectoapirest.modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hospital", schema = "bd_hospital_api")
public class HospitalClass {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "nombre", nullable = true, length = 35)
    private String nombre;
    @Basic
    @Column(name = "localidad", nullable = true, length = 15)
    private String localidad;
    @Basic
    @Column(name = "telefono", nullable = true, length = 9)
    private String telefono;
    @Basic
    @Column(name = "numero_camas", nullable = true)
    private Integer numeroCamas;

    public HospitalClass() {
    }

    public HospitalClass(int codigo, String nombre, String localidad, String telefono, Integer numeroCamas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
        this.numeroCamas = numeroCamas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(Integer numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalClass that = (HospitalClass) o;
        return codigo == that.codigo && Objects.equals(nombre, that.nombre) && Objects.equals(localidad, that.localidad) && Objects.equals(telefono, that.telefono) && Objects.equals(numeroCamas, that.numeroCamas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, localidad, telefono, numeroCamas);
    }
}
