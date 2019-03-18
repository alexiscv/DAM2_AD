/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Alexis
 */
@Entity
public class Terminal implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda 
    // genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String IMEITerminal;
    private String modelo;
    private String marca;

    // Relación
    // OneToOne: Bidireccional con Terminal
    // Una línea tiene un Terminal
    // Se etiqueta el atributo que representa la relación
    @OneToOne
    private Terminal terminal;

    /**
     * Constructor
     */
    public Terminal() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIMEITerminal() {
        return IMEITerminal;
    }

    public void setIMEITerminal(String IMEITerminal) {
        this.IMEITerminal = IMEITerminal;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

}
