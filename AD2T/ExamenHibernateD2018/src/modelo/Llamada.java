/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alexis
 */
@Entity
public class Llamada implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda 
    // genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int telefonoOrigen;
    private int telefonoDestino;
    private int duracionEnSegundos;
    private Date fechaInicio;

    // Relación ManyToOne: UNIDIRECCIONAL con SIMLinea
    // No debemos de hacer nada, esta parte
    // no es consciente de la relación.
    /**
     * Constructor
     */
    public Llamada() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTelefonoOrigen() {
        return telefonoOrigen;
    }

    public void setTelefonoOrigen(int telefonoOrigen) {
        this.telefonoOrigen = telefonoOrigen;
    }

    public int getTelefonoDestino() {
        return telefonoDestino;
    }

    public void setTelefonoDestino(int telefonoDestino) {
        this.telefonoDestino = telefonoDestino;
    }

    public int getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public void setDuracionEnSegundos(int duracionEnSegundos) {
        this.duracionEnSegundos = duracionEnSegundos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Llamada{" + "id=" + id + ", telefonoOrigen=" + telefonoOrigen + ", telefonoDestino=" + telefonoDestino + ", duracionEnSegundos=" + duracionEnSegundos + ", fechaInicio=" + fechaInicio + '}';
    }

}
