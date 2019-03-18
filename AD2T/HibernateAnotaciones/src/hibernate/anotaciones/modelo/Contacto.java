/*
 * Contacto.java
 *
 * Creada el 26-ago-2010, 14:33:03
 *
 * Clase Java desarrollada por Alex para el blog http://javatutoriales.blogspot.com/ el día 26-ago-2010
 *
 * Para informacion sobre el uso de esta clase, asi como bugs, actualizaciones, o mejoras enviar un mail a
 * programadorjavablog@gmail.com
 *
 */

package hibernate.anotaciones.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 26-ago-2010
 */
@Entity
@Table(name="contactos")
public class Contacto implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    
    @Column(name="e_mail")
    private String email;
    private String telefono;

    public Contacto()
    {
    }

    public Contacto(String nombre, String email, String telefono)
    {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getId()
    {
        return id;
    }

    private void setId(long id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
}