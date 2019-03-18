/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import hibernate.HibernateUtil;
import interfaces.UsuarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import modelo.Llamada;
import modelo.SIMLinea;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alexis
 */
public class UsuarioDAOImplementation implements UsuarioDAO {

    /**
     * Métedo que añade una línea al usuario 1
     *
     * @return
     */
    @Override
    public boolean contratarLinea() {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // DNI Usuario
            String dniUsuario = "11223344G";

            // Buscamos al Usuario de la DB
            Query queryUsuario = session.createQuery("FROM Usuario as u WHERE u.dni = :dniUsuario");
            queryUsuario.setParameter("dniUsuario", dniUsuario);

            // Lo recuperamos del ResultSet
            Usuario usuarioBD = (Usuario) queryUsuario.uniqueResult();

            System.out.println("USUARIO = " + usuarioBD.getNombre());

            // Creamos la nueva SIMLinea
            SIMLinea l = new SIMLinea();
            l.setNumeroTelefono(999888999);
            l.setDatosDisponibles(1024);
            l.setMinutosConsumidos(100);

            // Se la añadimos al Usuario
            usuarioBD.addLinea(l);

            // Persistimos la información
            System.out.println("Persistir Linea");
            session.save(l);

            // Comenzar transacción
            session.getTransaction().commit();

            // Retorno
            return true;

        } catch (Exception e) {
            Transaction tx = session.getTransaction();

            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return false;

    }

    @Override
    public boolean listadoUltimasLlamadas() {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Buscamos al Usuario de la DB
            Query q = session.createQuery("FROM Llamada as l ORDER BY fechaInicio DESC").setMaxResults(10);

            // Lo recuperamos del ResultSet
            List<Llamada> listaResultados = q.list();

            for (int i = 0; i < listaResultados.size(); i++) {

                Llamada ll = listaResultados.get(i);
                System.out.println("Datos de la Llamada " + i);
                System.out.println(ll.toString());

            }

            // Retorno
            return true;

        } catch (Exception e) {
            Transaction tx = session.getTransaction();

            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        // Retorno
        return false;

    }

    /**
     * Persite una nueva Llamada
     *
     * @return
     */
    @Override
    public boolean insertarLlamada() {

        Session sesion = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();

            Llamada ll = new Llamada();
            ll.setTelefonoOrigen(666999666);
            ll.setTelefonoDestino(650779900);
            ll.setDuracionEnSegundos(100);
            ll.setFechaInicio(new Date());

            // La persistimos
            sesion.save(ll);

            // Comenzar transacción
            sesion.getTransaction().commit();

            // Retorno
            return true;

        } catch (Exception e) {
            try {
                Transaction tx = sesion.getTransaction();
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
                throw new ExceptionDAO("ERROR Crear la Llamada");
            } catch (ExceptionDAO ex) {
                ex.getMessage();
            }
        } finally {
            sesion.close();
        }

        // Retorno
        return false;

    }

}
