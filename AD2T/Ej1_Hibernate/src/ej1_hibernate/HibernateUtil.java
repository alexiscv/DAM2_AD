/*
 * Lo primero que haremos es crear una clase ayudante o de utilidad 
 * llamada "HibernateUtil", que se hará cargo de inicializar y hacer 
 * el acceso al "org.hibernate.SessionFactory" (el objeto encargado de 
 * gestionar las sesiones de conexión a la base de datos que configuramos 
 * en el archivo "hibernate.cfg.xml") más conveniente.
 * 
 * Dentro de esta clase declaramos un atributo static de tipo 
 * "SessionFactory", así nos aseguraremos de que solo existe una 
 * instancia en la aplicación. Además lo declararemos como final para 
 * que la referencia no pueda ser cambiada después de que la hayamos 
 * asignado.
 */
package ej1_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Alexis
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
