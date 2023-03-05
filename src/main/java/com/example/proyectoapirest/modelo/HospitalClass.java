package com.example.proyectoapirest.modelo;

import jakarta.persistence.*;

//Indicamos a la clase que es una entidad
@Entity
//Asociamos con una tabla de la base de datos
@Table(name = "hospital", schema = "bd_hospital_api")
public class HospitalClass {
    //Indica que se basa en una columna de base de datos con incremento automatica y permite que
    //la base de datos genere un nuevo valor son cada operacion de insercion
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indica que es una clave primaria, lo identifica con la columna en la base de datos y agrega una
    //restricción no nula a la definición de la tabla
    @Id
    @Column(name = "codigo", nullable = false)
    private int codigo;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos, agrega una
    //restricción que puede ser nula y el tamanio de a la definición de la tabla
    @Basic
    @Column(name = "nombre", nullable = true, length = 35)
    private String nombre;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos, agrega una
    //restricción que puede ser nula y el tamanio de a la definición de la tabla
    @Basic
    @Column(name = "localidad", nullable = true, length = 15)
    private String localidad;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos, agrega una
    //restricción que puede ser nula y el tamanio de a la definición de la tabla
    @Basic
    @Column(name = "telefono", nullable = true, length = 9)
    private String telefono;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos y agrega una
    //restricción que puede ser nula a la definición de la tabla
    @Basic
    @Column(name = "numero_camas", nullable = true)
    private Integer numeroCamas;

    //Creamos un constructor vacio
    public HospitalClass() {
    }
    //Creamos un constructor con todos los atributos
    public HospitalClass(int codigo, String nombre, String localidad, String telefono, Integer numeroCamas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localidad = localidad;
        this.telefono = telefono;
        this.numeroCamas = numeroCamas;
    }
    //Generamos los getters y los setters
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

    //Generamos el metodo equals y hashCode para la comparacion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HospitalClass that = (HospitalClass) o;

        if (codigo != that.codigo) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (localidad != null ? !localidad.equals(that.localidad) : that.localidad != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (numeroCamas != null ? !numeroCamas.equals(that.numeroCamas) : that.numeroCamas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (numeroCamas != null ? numeroCamas.hashCode() : 0);
        return result;
    }
}
