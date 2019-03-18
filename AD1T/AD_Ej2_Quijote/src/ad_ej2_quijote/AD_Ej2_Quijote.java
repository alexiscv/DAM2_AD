/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej2_quijote;

import ad_ej2_quijote.logica.OperacionesFicheros;
import java.io.File;

/**
 *
 * @author Alexis
 */
public class AD_Ej2_Quijote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos un Obj. que referencia al archivo.
        File fichero = new File("quijote.txt");

        // Creamos un Obj. para manejar las operaciones
        OperacionesFicheros operacion = new OperacionesFicheros();

        // Contar número de líneas
        System.out.println("El Quijote tiene " + operacion.contarLineas(fichero) + " líneas.");

        // Contar número de palabras
        System.out.println("El Quijote tiene " + operacion.contarPalabras(fichero) + " palabras.");

        // Contar número de veces que se repite una palabra
        System.out.println("Quijote aparece " + operacion.contarPalabra(fichero, "Quijote") + " veces.");

        // Contar número de letras
        System.out.println("El Quijote tiene " + operacion.contarLetras(fichero) + " letras.");

        // El Quijote con las líneas escritas al revés
        if (operacion.crearFicheroAlReves(fichero, new File("quijoteReves.txt"))) {
            System.out.println("El Quijote se ha guardado al revés con éxito.");

        }
        
        // Palabras distintas que hay en el texto y el número de veces que aparecen.
        operacion.verPalabrasContando(fichero);
        
        // Dividir el Quijote en capitulos
        operacion.dividirEnCapitulos(fichero, "Capítulo ");

    }

}
