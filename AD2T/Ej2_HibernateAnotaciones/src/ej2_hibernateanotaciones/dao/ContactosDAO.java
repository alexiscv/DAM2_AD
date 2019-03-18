/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2_hibernateanotaciones.dao;

import ej2_hibernateanotaciones.modelo.Contacto;
import ej2_hibernateanotaciones.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alexis
 */
public class ContactosDAO {

    private Session sesion;
    private Transaction tx;

    /**
     * Iniciar una sesión y una transacción en la base de datos
     *
     * @throws HibernateException
     */
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    /**
     * nos ayudará a manejar las cosas en caso de que ocurra una excepción. Si
     * esto pasa queremos que la transacción que estamos ejecutando se deshaga y
     * se relance la excepción
     *
     * @param he
     * @throws HibernateException
     */
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    /**
     * Como guardar un objeto "Contacto". Para esto Hibernate proporciona el
     * método "save" en el objeto de tipo "org.hibernate.Session", que se
     * encarga de generar el "INSERT" apropiado para la entidad que estamos
     * tratando de guardar.
     *
     * @param contacto
     * @return
     */
    public long guardaContacto(Contacto contacto) {
        long id = 0;

        try {
            iniciaOperacion();
            id = (Long) sesion.save(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }

    /**
     * actualizar un "Contacto". Para eso usamos el método "update" del objeto
     * "sesion" en nuestro método "actualizaContacto":
     *
     * @param contacto
     * @throws HibernateException
     */
    public void actualizaContacto(Contacto contacto) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * Eliminar un contacto
     *
     * @param contacto
     * @throws HibernateException
     */
    public void eliminaContacto(Contacto contacto) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(contacto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    /**
     * La forma más fácil es buscar una entidad particular usando su "id". La
     * clase "org.hibernate.Session" proporciona dos métodos para esto: "load" y
     * "get". Los dos hacen prácticamente lo mismo: en base al identificador y
     * tipo de la entidad recuperan la entidad indicada, con la diferencia de
     * que "load" lanza una excepción en caso de que la entidad indicada no sea
     * encontrada en la base de datos, mientras que "get" simplemente regresa
     * "null". Pueden usar el que prefieran, en lo personal me gusta más "get",
     * así que lo usaré para el método "obtenContacto":
     *
     * @param idContacto
     * @return
     * @throws HibernateException
     */
    public Contacto obtenContacto(long idContacto) throws HibernateException {
        Contacto contacto = null;

        try {
            iniciaOperacion();
            contacto = (Contacto) sesion.get(Contacto.class, idContacto);
        } finally {
            sesion.close();
        }
        return contacto;
    }

    public List<Contacto> obtenListaContactos() throws HibernateException {
        List<Contacto> listaContactos = null;

        try {
            iniciaOperacion();
            listaContactos = sesion.createQuery("from Contacto").list();
        } finally {
            sesion.close();
        }

        return listaContactos;
    }

}
