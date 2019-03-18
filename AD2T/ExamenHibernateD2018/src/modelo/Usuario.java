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
import javax.persistence.OneToMany;

/**
 *
 * @author Alexis
 */
@Entity
public class Usuario implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda 
    // genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String dni;
    private String nombre;
    private String apellido;

    // Un usuario tiene varias SIMLineas
    // Relación @OneToMany: Bidireccional
    // Añadimos el atributo List que contiene los n elementos Many
    // Debe estar inicializado para evitar un NullPointerException
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<SIMLinea> simLineas = new ArrayList<>();

    /**
     * Constructor. Es necesario que sea vacío.
     */
    public Usuario() {
    }

    // -------- GETTER & SETTER ------ //
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

    public List<SIMLinea> getSimLineas() {
        return simLineas;
    }

    public void setSimLineas(List<SIMLinea> simLineas) {
        this.simLineas = simLineas;
    }

    /**
     * Añade una línea al Usuario
     *
     * @param l
     */
    public void addLinea(SIMLinea l) {
        this.simLineas.add(l);
    }

}
