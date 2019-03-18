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
import javax.persistence.OneToOne;

/**
 *
 * @author Alexis
 */
@Entity
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private int telefono;
    private String email;
    private int fax;

    // Relación UNO A MUCHOS: BIDIRECCIONAL con Cliente
    // Si la surcusal desaparece se borran los clientes
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sucursal")
    private List<Cliente> clientes = new ArrayList<Cliente>();

    // Relación UNO A UNO: UNIDIRECCIONAL con Direccion
    // Marcamos el atributo que crea relaciona a las clases
    // Si la sucursal desaparece la direccion permanece
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Direccion direccion;

    /**
     * COnstructor
     */
    public Sucursal() {
    }

    // ----------- GETTER & SETTER -------------- //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Nos permite añadir un cliente a la Sucursal
     *
     * @param cliente
     */
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

}
