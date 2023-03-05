package com.example.proyectoapirest.modelo;

import jakarta.persistence.*;

//Indicamos a la clase que es una entidad
@Entity
//Asociamos con una tabla de la base de datos
@Table(name = "enfermera", schema = "bd_hospital_api")
public class EnfermeraClass {
    //Indica que se basa en una columna de base de datos con incremento automatica y permite que
    //la base de datos genere un nuevo valor son cada operacion de insercion
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indica que es una clave primaria, lo identifica con la columna en la base de datos y agrega una
    //restricción no nula a la definición de la tabla
    @Id
    @Column(name = "enfermera_cod", nullable = false)
    private int enfermeraCod;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos, agrega una
    //restricción que puede ser nula y el tamanio de a la definición de la tabla
    @Basic
    @Column(name = "nombre", nullable = true, length = 20)
    private String nombre;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos, agrega una
    //restricción que puede ser nula y el tamanio de a la definición de la tabla
    @Basic
    @Column(name = "apellido", nullable = true, length = 30)
    private String apellido;
    //Indica que no es una clave primaria, lo identifica con la columna en la base de datos y marcan
    //que la definición de la tabla solo es para lectura
    @Basic
    @Column(name = "codigo_hospital", insertable = false, updatable = false)
    private int codigoHospital;
    //Identifica el tipo de relacion de las tablas, que es una clave foranea
    @ManyToOne
    //Creamos la asociacion entre las tablas
    @JoinColumn(name = "codigo_hospital", referencedColumnName = "codigo", nullable = false)
    private HospitalClass hospitalByCodigo;

    //Creamos un constructor vacio
    public EnfermeraClass() {
    }
    //Creamos un constructor con todos los atributos
    public EnfermeraClass(int enfermeraCod, String nombre, String apellido, int codigoHospital, HospitalClass hospitalByCodigo) {
        this.enfermeraCod = enfermeraCod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoHospital = codigoHospital;
        this.hospitalByCodigo = hospitalByCodigo;
    }

    //Generamos los getters y los setters
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

    //Generamos el metodo equals y hashCode para la comparacion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnfermeraClass that = (EnfermeraClass) o;

        if (enfermeraCod != that.enfermeraCod) return false;
        if (codigoHospital != that.codigoHospital) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = enfermeraCod;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + codigoHospital;
        return result;
    }
}
