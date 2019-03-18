/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Alexis
 */
@Entity 
public class Cliente implements Serializable {

    // Anotación para el IDENTIFICADOR
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dni;
    private String nombre;
    private String apellido;

    // Relación UNO A MUCHOS: BIDIRECCIONAL con Cuenta
    // Si el cliente desaparece sus cuentas tambien deben desaparecer
    // El lado MANY es el propietario, marcamos con mappedBy el atributo de enlace
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    // Relación MUCHOS A UNO: BIDIRECCIONAL con Sucursal
    // Marcamos el atributo que vincula las clases
    @ManyToOne
    private Sucursal sucursal;

    /**
     * Constructor vacio, necesario
     */
    public Cliente() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * Nos permite añadir una cuenta al Cliente
     *
     * @param cuenta
     */
    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

}
