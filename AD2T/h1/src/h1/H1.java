/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import entity.Actor;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author J
 */
public class H1 {

    /**
     * @param args the command line arguments
     */
    private static Transaction tx;
    private static Session sesion;

    public static void main(String[] args) {
        // TODO code application logic here

        // Ejemplo de transaccion con la clase Actor
        //  realizaTransacion();


        // Ejemplo
        consultarUltimosFilmActualizados();


    }

    /*
     * EJEMPLO 1: Consultas HQL y SQL 
     */
    /*
     * Permite iniciar la transación de datos con la DB
     */
    private static void iniciaOperacion() {
        //opcion 1: abre una nueva sesionFactory
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();//le pasa a la sesion antes declarada la sesonFactory y la abre
        sesion.getTransaction().begin();//permite que comience la transacion

    }

    /*
     * Permite finalizar la transacion de datos con la DB
     */
    private static void terminaOperacion() {
        sesion.getTransaction().commit();//confirma la transacion
        sesion.close();//cierra la sesion
    }

    // realiza las consultas HQL o SQL
    public static void consultarUltimosFilmActualizados() {
        iniciaOperacion();

        // opcion1 HQL Query
        Query query = sesion.createQuery(" FROM Actor as f  order by last_update desc");        
        List<Actor> listaResultados = query.list();
        
      
        
        //Opcion 2 SQL

        SQLQuery sqlQuery = sesion.createSQLQuery("SELECT * FROM actor ORDER BY last_update DESC");
      
        
        sqlQuery.addEntity(Actor.class);
        List<Actor> listaResultadosSQL = sqlQuery.list();


        Iterator itrListaResultados = listaResultados.iterator();
        while (itrListaResultados.hasNext()) {
            Actor element = (Actor) itrListaResultados.next();
            System.out.print(element.getFirstName() + " ");
        }


        terminaOperacion();
    }

    // EJEMPLO 2: Persistencia, obtención, modificación y borrado de objetos en Hibrenate con transaciones
    public static void realizaTransacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        Session sess = sessionFactory.openSession();

        try {
            tx = sess.beginTransaction();
            Actor actor1 = new Actor();

                      
             // Caso 1:  persistiendo un objeto
                   
             //   actor1.setActorId((short)44); // si no ponemos nada lo añade al final
             
             
             actor1.setFirstName("Alex");
             actor1.setLastName("De la Iglesia");
             Date lastupdate = new Date();
             lastupdate.getTime();
             actor1.setLastUpdate(lastupdate);
             
             sess.merge(actor1); //Copy the state of the given object onto the persistent object with the same identifier.
             

            // Caso 2: obteniendo un objeto
            short i = 201; // indice de la serie
            actor1 = (Actor) sess.get(Actor.class, i);
            if (actor1 != null) {
                System.out.println(actor1.getActorId() + " " + actor1.getFirstName());
            } else {
                System.out.println("no existe ese indice");
            }


            // Caso 3: modificando un objeto
            if (actor1 != null) {
                actor1.setFirstName("Alejandro");
                sesion.update(actor1);
            }

            sesion.save(actor1);
            // Caso 4: borrando un objeto
            // sess.delete(actor1);



            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            sess.close();
        }
    }
}