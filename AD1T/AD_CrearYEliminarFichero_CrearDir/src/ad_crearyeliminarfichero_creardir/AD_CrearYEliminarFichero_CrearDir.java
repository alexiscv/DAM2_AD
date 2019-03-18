/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_crearyeliminarfichero_creardir;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author PCCOM
 */
public class AD_CrearYEliminarFichero_CrearDir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Crear un Fichero
         */
        try {

            // Creamos el obj. que encapsula el fichero
            File fichero = new File("C:\\pruebasAD\\miFichero.txt");

            // A partir del objeto File creamos el fichero físicamente
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente.");

            } else {
                System.out.println("No se ha podido crear el fichero.");
            }

        } catch (IOException e) {
            e.getMessage();
        }

        /**
         * Eliminar un Fichero
         */
        File f = new File("C:\\pruebasAD", "miFichero.txt");
        if (f.exists()) {
            f.delete();
        }

        /**
         * Crear un directorio
         */
        try {

            // Declaración de variables
            String directorio = "C:\\prueba";
            String varios = "C:\\carpeta1\\carpeta2\\carpeta3";

            // Crear un directorio
            boolean exito = (new File(directorio)).mkdir();

            if (exito) {
                System.out.println("Directorio: " + directorio + " creado.");
            }

            // Crear varios directorios
            exito = (new File(varios)).mkdirs();

            if (exito) {
                System.out.println("Directorios: " + varios + " creados.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
