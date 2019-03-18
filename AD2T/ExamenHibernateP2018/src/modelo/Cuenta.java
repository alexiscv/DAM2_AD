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
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numeroCC;
    private float saldo;
    private char divisa;

    // Relación MUCHOS A UNO: BIDIRECCIONAL con Cliente
    // Marcamos el atributo que vincula las clases
    @ManyToOne
    private Cliente cliente;

    // Relación UNO A MUCHOS: UNIDIRECCIONAL con Movimiento
    // Si se borra una cuenta, se deben borrar sus movimientos
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    /**
     * Constructor
     */
    public Cuenta() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroCC() {
        return numeroCC;
    }

    public void setNumeroCC(String numeroCC) {
        this.numeroCC = numeroCC;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public char getDivisa() {
        return divisa;
    }

    public void setDivisa(char divisa) {
        this.divisa = divisa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * Nos permite añadir un movimiento a la cuenta
     *
     * @param movimiento
     */
    public void addMovimiento(Movimiento movimiento) {
        this.movimientos.add(movimiento);
    }

}
