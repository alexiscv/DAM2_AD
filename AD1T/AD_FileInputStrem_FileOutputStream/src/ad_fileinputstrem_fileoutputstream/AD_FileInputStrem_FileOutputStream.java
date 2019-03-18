/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_fileinputstrem_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author PCCOM
 */
public class AD_FileInputStrem_FileOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Vamos a ver un ejemplo de como escribir en el fichero, usaremos el
         * método write con el que podemos usar un numero que corresponderá a la
         * tabla ASCII o un array de bytes. Crearemos un fichero con una
         * extensión propia.
         */
        try (FileOutputStream fos = new FileOutputStream("C:\\pruebasAD\\fichero_bin.ddr")) {

            String texto = "Esto es una prueba para ficheros binariosssss";

            //Copiamos el texto en un array de bytes
            byte codigos[] = texto.getBytes();

            fos.write(codigos);

        } catch (IOException e) {

        }

        /**
         * Ahora veremos como se lee, es prácticamente igual que vimos con
         * FileReader, usando el método read(), cuando llega al final del
         * fichero devuelve -1. Su diferencia básica es que con FileReader
         * leemos caracteres y FileInputStream lee bytes.
         */
        try (FileInputStream fis = new FileInputStream("C:\\pruebasAD\\fichero_bin.ddr")) {

            int valor = fis.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = fis.read();
            }

        } catch (IOException e) {

        }
    }

}
