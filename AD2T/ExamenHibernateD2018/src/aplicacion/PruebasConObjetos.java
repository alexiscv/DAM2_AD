/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import hibernate.HibernateUtil;
import java.util.Date;
import modelo.Llamada;
import modelo.SIMLinea;
import modelo.Tarifa;
import modelo.Terminal;
import modelo.Usuario;
import org.hibernate.Session;

/**
 *
 * @author Alexis
 */
public class PruebasConObjetos {

    public static void main(String[] args) {

        // Creamos un USUARIO
        Usuario u = new Usuario();
        u.setDni("11223344G");
        u.setNombre("John");
        u.setApellido("Doe");

        // Creamos un SIMLINEA
        SIMLinea l = new SIMLinea();
        l.setNumeroTelefono(666999666);
        l.setDatosDisponibles(1024);
        l.setMinutosConsumidos(100);

        // Creamos un TARIFA
        Tarifa t = new Tarifa();
        t.setNombreTarifa("Tarifa Ardilla");
        t.setGigasMaxDatos(2028);
        t.setMinutosMaxLlamadas(1000);

        // Creamos una Llamada
        Llamada ll = new Llamada();
        ll.setTelefonoOrigen(666999666);
        ll.setTelefonoDestino(666000000);
        ll.setDuracionEnSegundos(60);
        ll.setFechaInicio(new Date());

        // Creamos un Terminal
        Terminal te = new Terminal();
        te.setIMEITerminal("EFG88765");
        te.setModelo("Redmi Note 2");
        te.setMarca("Xiaomi");

        // Operaciones -------------
        // Añadir linea al Usuario
        u.addLinea(l);

        // Añadir Usuario a la Linea
        l.setUsuario(u);

        // Añadir Tarifa a la línea
        l.addTarifa(t);

        // Añadir una llamada a la línea
        l.addLlamada(ll);

        // Añadir un terminal a la Línea
        l.setTerminal(te);

        // --- IBERNATE --- //
        // Iniciamos la sesión
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();

        // Guardar un registro
        sesion.save(u);

        // Actualizar un registro
        u.setApellido("apellido modificado");
        sesion.update(u);

        // Eliminar un registro
        sesion.delete(u);

        // Lanzamos la transacción y cerramos la sesión
        sesion.getTransaction().commit();
        sesion.close();
    }

}
