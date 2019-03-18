/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_copiarfichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author PCCOM
 */
public class AD_CopiarFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Clase para leer los datos de un fichero
        FileInputStream fuente = null;

        // Clase para escribir los datos a un fichero
        FileOutputStream destino = null;

        try {
            // El fichero fuente es el primer parámetro
            fuente = new FileInputStream(new File("C:\\pruebasAD\\ejemploCopiaOrigen.txt"));

            // El fichero destino es el segundo parámetro.
            destino = new FileOutputStream(new File("C:\\pruebasAD\\ejemploCopiaDestino.txt"), true);

            // Leer del fuente hasta llegar la fin de archivo
            int i = fuente.read();

            while (i != -1) { // mientras not EOF
                destino.write(i);
                i = fuente.read();
            }

            // Cerrar los ficheros
            fuente.close();
            destino.close();

        } catch (IOException e) {
            System.out.println("Error en operaciones de ficheros");
        }

    }
}
