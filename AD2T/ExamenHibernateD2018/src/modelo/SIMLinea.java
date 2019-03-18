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
import javax.persistence.OneToOne;

/**
 *
 * @author Alexis
 */
@Entity
public class SIMLinea implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda 
    // genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numeroTelefono;
    private int datosDisponibles;
    private int minutosConsumidos;

    // Relación 
    // ManyToOne: Bidireccional con Usuario
    // Muchas lineas pertenecen a un usuario.
    // En ManyToOne Bidireccional, la parte Many contiene una ref. a One
    @ManyToOne
    private Usuario usuario;

    // Relación 
    // OneToMany: Bidireccional con Tarifa
    // Una Linea puede tener varias Tarifas
    // La parte One añade mappedBy indicando el atributo que repesenta a One en Many
    // Indicamos que operaciones se harán en cascada ALL
    // Y como será la recuperación de datos EAGER (Inmediato)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "simLinea")
    private List<Tarifa> tarifas = new ArrayList<>();

    // Relación
    // OneToMany: UNIDIRECCIONAL con Llamada
    // Una Linea realiza Muchas Llamada
    // Si se borra una LINEA, se deben borrar sus LLAMADAS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Llamada> llamadas = new ArrayList<Llamada>();

    // Relación
    // OneToOne: Bidireccional con Terminal
    // Una línea tiene un Terminal
    // Se etiqueta el atributo que representa la relación
    @OneToOne(cascade = CascadeType.ALL) 
    private Terminal terminal;

    /**
     * Constructor
     */
    public SIMLinea() {
    }

    // -------- GETTER & SETTER ------ //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getDatosDisponibles() {
        return datosDisponibles;
    }

    public void setDatosDisponibles(int datosDisponibles) {
        this.datosDisponibles = datosDisponibles;
    }

    public int getMinutosConsumidos() {
        return minutosConsumidos;
    }

    public void setMinutosConsumidos(int minutosConsumidos) {
        this.minutosConsumidos = minutosConsumidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getTarifas() {
        return tarifas;
    }

    public void setTarifas(List tarifas) {
        this.tarifas = tarifas;
    }

    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    /**
     * Añade una tarifa a la lista de tarifas
     *
     * @param t
     */
    public void addTarifa(Tarifa t) {
        this.tarifas.add(t);
    }

    /**
     * Añade una llamada a la lista de llamadas
     *
     * @param ll
     */
    public void addLlamada(Llamada ll) {
        this.llamadas.add(ll);
    }

}
