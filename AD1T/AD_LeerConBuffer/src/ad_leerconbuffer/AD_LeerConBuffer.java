/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_leerconbuffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alexis
 */
public class AD_LeerConBuffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String texto = "";

        try {
            
            // Crear el flujo de salida
            FileReader fichero = null;

            // Ruta y nombre del fichero
            fichero = new FileReader("C:\\pruebasAD\\leeme.txt");

            // Montar un buffer sobre ese flujo
            BufferedReader buffer = new BufferedReader(fichero);

            // Escribimos el texto usando el metodo readLine()
            while ((texto = buffer.readLine()) != null) {
                System.out.println(texto);
            }

            // Cerrar fichero
            fichero.close();
            
        } catch (IOException e) {
            // Escribir el error en la consola
            System.err.println("Error: " + e);
            
        }

    }

}
