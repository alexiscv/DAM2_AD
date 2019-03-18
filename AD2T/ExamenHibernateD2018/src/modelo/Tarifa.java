/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alexis
 */
@Entity
public class Tarifa implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda 
    // genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreTarifa;
    private int gigasMaxDatos;
    private int minutosMaxLlamadas;

    // Relación ManyToOne: Bidireccional con SIMLinea
    // Muchas Tarifa tienen una SIMLinea
    // La parte Many solo añade un atrib. de tipo Many
    @ManyToOne
    private SIMLinea simLinea;

    /**
     * Constructor
     */
    public Tarifa() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
    }

    public int getGigasMaxDatos() {
        return gigasMaxDatos;
    }

    public void setGigasMaxDatos(int gigasMaxDatos) {
        this.gigasMaxDatos = gigasMaxDatos;
    }

    public int getMinutosMaxLlamadas() {
        return minutosMaxLlamadas;
    }

    public void setMinutosMaxLlamadas(int minutosMaxLlamadas) {
        this.minutosMaxLlamadas = minutosMaxLlamadas;
    }

    public SIMLinea getSimLinea() {
        return simLinea;
    }

    public void setSimLinea(SIMLinea simLinea) {
        this.simLinea = simLinea;
    }

}
