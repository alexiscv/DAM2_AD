package ej2_hibernateanotaciones.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Todos los atributos que no estén marcados como "transient" o con la anotación
 * "javax.persistence.Transient" serán persistidas.
 */
/**
 * La anotación más importante es "javax.persistence.Entity", la cual indica que
 * la clase es una "Entidad", por lo que la anotación se coloca a nivel de
 * clase. Añadimos la anotación @Table para indicar el nombre, sino se crearia
 * automáticamente pero su nombre seria en singular y no en plural.
 */
@Entity
@Table(name = "contactos")
public class Contacto implements Serializable {

    // Establecemos el IDENTIFICADOR de la clase
    // Identificación por atributo
    // Podemos personalizar como se generarán los identificadores
    // Las más usadas son "AUTO" e "IDENTITY". 
    // La primera usa la estrategia por default de la base de datos, mientras que la segunda genera los identificadores en orden (1, 2, 3, etc.)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    // Nos permite establecer un nombre personalizado para la columna
    @Column(name = "e_mail")
    private String email;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
