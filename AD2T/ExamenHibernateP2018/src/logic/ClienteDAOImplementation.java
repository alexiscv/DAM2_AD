/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import hibernate.HibernateUtil;
import interfaces.ClienteDAO;
import java.util.Date;
import modelo.Cuenta;
import modelo.Movimiento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alexis
 */
public class ClienteDAOImplementation implements ClienteDAO {

    /**
     * Realiza una transferencia entre cuentas del mismo cliente Persiste las
     * cuentas actualizadas
     *
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param cantidad
     * @return
     */
    @Override
    public boolean traspaso(String cuentaOrigen, String cuentaDestino, float cantidad) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // Creamos las consultas a la espera de sus parametros
            // Con estas consultas recuperaremos los datos de las cuentas del cliente
            Query queryCuentaOrigen = session.createQuery("FROM Cuenta as c WHERE c.numeroCC = :cuentaOrigen");
            Query queryCuentaDestino = session.createQuery("FROM Cuenta as c WHERE c.numeroCC = :cuentaDestino");

            // Establecemos los parametros, usando los valores que nos llegan
            // desde la llamada al método
            queryCuentaOrigen.setParameter("cuentaOrigen", cuentaOrigen);
            queryCuentaDestino.setParameter("cuentaDestino", cuentaDestino);

            // Recuperamos el resultado
            Cuenta cuentaOrigenRespuesta = (Cuenta) queryCuentaOrigen.uniqueResult();
            Cuenta cuentaDestinoRespuesta = (Cuenta) queryCuentaDestino.uniqueResult();

            // Comprobamos que ambas cuentas pertenecen al mismo Cliente
            if (cuentaOrigenRespuesta.getCliente().getDni().equals(cuentaDestinoRespuesta.getCliente().getDni()) && cuentaOrigenRespuesta.getSaldo() >= cantidad) {
                // Las cuentas son del mismo cliente
                // Descontamos el dinero de la primera cuenta
                cuentaOrigenRespuesta.setSaldo(cuentaOrigenRespuesta.getSaldo() - cantidad);

                // Aumentamos el saldo de la segunda cuenta
                cuentaDestinoRespuesta.setSaldo(cuentaDestinoRespuesta.getSaldo() + cantidad);

                // Registramos el movimiento bancario
                Movimiento movimiento = new Movimiento();
                movimiento.setCantidad(cantidad);
                movimiento.setConcepto("TRABSFERENCIA");
                movimiento.setFecha(new Date(987654321));
                cuentaOrigenRespuesta.addMovimiento(movimiento);

                // Persistimos la información
                session.save(cuentaOrigenRespuesta);
                session.save(cuentaDestinoRespuesta);

                // Retorno
                return true;

            } else {
                // Las cuentas con de clientes distintos
                throw new ExceptionDAO("Error Traspaso. Las cuentas no pertenecen al mismo cliente o no hay saldo suficiente.");
            }

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

    /**
     * Realiza una transferencia entre cuentras de distintos clientes. Persiste
     * las cuentas actualizadas.
     *
     * @param cuentaOrigen
     * @param cuentaDestino
     * @param cantidad
     * @return
     */
    @Override
    public boolean tranferencia(String cuentaOrigen, String cuentaDestino, float cantidad) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // Buscamos la información de la cuenta Origen y Destino
            Query queryCuenaOrigen = session.createQuery("FROM Cuenta as c WHERE c.numeroCC = :cuentaOrigen");
            Query queryCuenaDestino = session.createQuery("FROM Cuenta as c WHERE c.numeroCC = :cuentaDestino");

            // Parametrizamos la búsqueda
            queryCuenaOrigen.setParameter("cuentaOrigen", cuentaOrigen);
            queryCuenaDestino.setParameter("cuentaDestino", cuentaDestino);

            // Almacenamos en unos Obj. el resultado de las consultas
            Cuenta cuentaOrigenRespuesta = (Cuenta) queryCuenaOrigen.uniqueResult();
            Cuenta cuentaDestinoRespuesta = (Cuenta) queryCuenaOrigen.uniqueResult();

            // Si las cuentas son de distintos clientes y hay saldo sufuciente...
            if (!cuentaOrigenRespuesta.getCliente().getDni().equals(cuentaDestinoRespuesta.getCliente().getDni()) && cuentaOrigenRespuesta.getSaldo() >= cantidad) {

                // Saldo de la cuenta origen
                float saldoOrigen = cuentaOrigenRespuesta.getSaldo();

                // Restamos la cantidad a transferir al saldo de la cuenta origen
                cuentaOrigenRespuesta.setSaldo(saldoOrigen - cantidad);

                // Saldo de la cuenta Destino
                float saldoDestino = cuentaDestinoRespuesta.getSaldo();

                // Sumamos el dinero de la transferencia a la cuenta Destino
                cuentaDestinoRespuesta.setSaldo(saldoDestino + cantidad);

                // Creamos un Obj. movimiento
                Movimiento movimiento = new Movimiento();
                movimiento.setCantidad(cantidad);                   // Cantidad
                movimiento.setConcepto("transferencia");            // Concepto
                movimiento.setFecha(new Date(987654321));           // Fecha

                // Añadimos el movimiento a la cuenta Origen
                cuentaOrigenRespuesta.addMovimiento(movimiento);

                // Guardamos en la base de datos
                session.save(cuentaOrigenRespuesta);
                session.save(cuentaDestinoRespuesta);

                // Resultado
                return true;

            } else {
                throw new ExceptionDAO("Error Transferencia");
            }
        } catch (Exception e) {
            Transaction tx = session.getTransaction();
            System.err.println(e.getMessage());
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            // Cerramos la sesión
            session.close();
        }

        // Resultado
        return false;

    }

    /**
     * Crea una cuenta con datos aleatorios. Despues la persiste en la base de
     * datos
     *
     * @return
     */
    @Override
    public boolean crearCuenta() {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();

            Cuenta cuenta = new Cuenta();
            cuenta.setDivisa('e');
            int generado = (int) ((Math.random() * 1000) + 1);
            cuenta.setNumeroCC(String.valueOf(generado));
            cuenta.setSaldo(generado);
            sesion.save(cuenta);
            return true;

        } catch (Exception e) {
            try {
                Transaction tx = sesion.getTransaction();
                e.printStackTrace();
                if (tx != null) {
                    tx.rollback();
                }
                throw new ExceptionDAO("ERROR Crear cuenta");
            } catch (ExceptionDAO ex) {
                ex.getMessage();
            }
        } finally {
            sesion.close();
        }
        return false;
    }

}
