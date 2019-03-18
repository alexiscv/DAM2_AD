/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdbc_pintores;

import java.sql.SQLException;

/**
 *
 * @author Alexis
 */
public class EjercicioJDBC_Pintores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {

            // Creamos el OBJ.
            PinturasDB pinturasDB = new PinturasDB();
            
            // Borrar todo
            pinturasDB.deleteAllPintores();

            // Insertamos unos pintores
            pinturasDB.insertPintor("Picasso", 1675, "cubista");
            pinturasDB.insertPintor("Greco", 1644, "Pintaba oscuro");
            pinturasDB.insertPintor("Goya", 1887, "Naturalista");

            // Retornamos todos los PINTORES
            System.out.println("==  LISTADO DE PINTORES ==");
            pinturasDB.getAllPintores();
            
            // Eliminar un Pintor
            pinturasDB.deletePintor("Greco");
            
            // Retornamos todos los PINTORES
            System.out.println("==  LISTADO DE PINTORES ==");
            pinturasDB.getAllPintores();
            
            // Retornamos los cuadros de un determinado año
            System.out.println("==  LISTADO DE PINTORES AÑO ==");
            pinturasDB.getPintoresFromYear(1887);
            
            // Retornamos los cuadros de un determinado año
            System.out.println("==  LISTADO DE CUADROS DE AUTOR ==");
            pinturasDB.getAllCuadrosOf(1);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
