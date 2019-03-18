/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_filtrarficheroslistando;

import java.io.File;

/**
 *
 * @author Alexis
 */
public class AD_FiltrarFicherosListando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            
            // Obtenemos el listado de los archivos de ese directorio
            File fichero = new File("C:\\");
            String[] listadeArchivos = fichero.list();

            // Filtraremos por los de extensión .txt
            listadeArchivos = fichero.list(new Filtrar(".log"));

            // Comprobamos el número de archivos en el listado
            int nArchivos = listadeArchivos.length;

            // Si no hay ninguno avisamos por consola
            if (nArchivos < 1) {
                System.out.println("No hay archivos que listar.");
            } else {
                // Si hay archivos para listar...
                for (int i = 0; i < nArchivos; i++) {
                    System.out.println(listadeArchivos[i]);

                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar en la ruta indicada.");

        }

    }

}
