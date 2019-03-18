/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2_hibernateanotaciones;

import ej2_hibernateanotaciones.dao.ContactosDAO;
import ej2_hibernateanotaciones.modelo.Contacto;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactosDAO contactosDAO = new ContactosDAO();
        Contacto contactoRecuperado = null;
        long idAEliminar = 0;

        //Creamos tres instancias de Contacto 
        Contacto contacto1 = new Contacto("Contacto 1", "contacto1@contacto.com", "12345678");
        Contacto contacto2 = new Contacto("Contacto 2", "contacto2@contacto.com", "87654321");
        Contacto contacto3 = new Contacto("Contacto 3", "contacto3@contacto.com", "45612378");

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        idAEliminar = contactosDAO.guardaContacto(contacto1);
        contactosDAO.guardaContacto(contacto2);
        contactosDAO.guardaContacto(contacto3);

        //Modificamos el contacto 2 y lo actualizamos 
        contacto2.setNombre("Nuevo Contacto 2");
        contactosDAO.actualizaContacto(contacto2);

        //Recuperamos el contacto1 de la base de datos 
        contactoRecuperado = contactosDAO.obtenContacto(idAEliminar);
        System.out.println("Recuperamos a " + contactoRecuperado.getNombre());

        //Eliminamos al contactoRecuperado (que es el contacto3) 
        contactosDAO.eliminaContacto(contactoRecuperado);

        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Contacto> listaContactos = contactosDAO.obtenListaContactos();
        System.out.println("Hay " + listaContactos.size() + "contactos en la base de datos");

        for (Contacto c : listaContactos) {
            System.out.println("-> " + c.getNombre());
        }

    }

}
