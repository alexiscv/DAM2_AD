/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import hibernate.HibernateUtil;
import java.util.Date;
import modelo.Cliente;
import modelo.Cuenta;
import modelo.Direccion;
import modelo.Movimiento;
import modelo.Sucursal;
import org.hibernate.Session;

/**
 *
 * @author Alexis
 */
public class PruebasConObjetos {

    public static void main(String[] args) {

        //Crear direccion
        Direccion d1 = new Direccion();
        d1.setCalle("calle1");
        d1.setCp(33932);
        d1.setCiudad("ciudad");
        d1.setProvincia("provincia");

        //Crear sucursal
        Sucursal s1 = new Sucursal();
        s1.setNumero(1);
        s1.setTelefono(985);
        s1.setEmail("email");
        s1.setFax(658);
        //asignar direccion a sucursal
        s1.setDireccion(d1);

        //Crear movimiento
        Movimiento m1 = new Movimiento();
        m1.setCantidad(5);
        m1.setConcepto("concepto");
        m1.setFecha(new Date(56847521));

        //Crear cuenta
        Cuenta c1 = new Cuenta();
        c1.setNumeroCC("numeroCC");
        c1.setSaldo(500f);
        c1.setDivisa('e');
        //asignar movimiento a cuenta
        c1.addMovimiento(m1);

        //Crear cliente
        Cliente cliente0 = new Cliente();
        cliente0.setDni("dni");
        cliente0.setNombre("nombre");
        cliente0.setApellido("apellido");

        //asignar al cliente una cuenta
        cliente0.addCuenta(c1);
        //asignar a la sucursal un cliente
        s1.addCliente(cliente0);

        // --- IBERNATE --- //
        // Iniciamos la sesión
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();

        // Guardar un registro
        sesion.save(cliente0);

        // Actualizar un registro
        cliente0.setApellido("apellido modificado");
        sesion.update(cliente0);

        // Eliminar un registro
        sesion.delete(cliente0);

        // Lanzamos la transacción y cerramos la sesión
        sesion.getTransaction().commit();
        sesion.close();

    }

}
