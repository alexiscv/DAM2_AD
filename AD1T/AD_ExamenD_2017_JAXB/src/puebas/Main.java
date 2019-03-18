/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puebas;

import java.io.File;
import java.util.Map;
import logica.OperacionesDiccionario;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instanciamos la clase que nos permite operar con el diccionario
        OperacionesDiccionario op = new OperacionesDiccionario();

        // 1.- Contar el total de sinónimos y el total de antónimos 
        // que contienen una determinada palabra
        op.getTotalSinonimoAntonimosDe("String");

        // 2.- Borrar todas las palabras que en su grafía contienen una 
        // determinada cadena de caracteres texto
        op.borrarPalabrasQueContiene("abc");

        // 3.- Generar un Map<K,V> donde K es la grafía y V es el total de 
        // sinonimos con similitud > 80%
        Map<String, Integer> mapa = op.obtenerSinonimosSuperioresPorcentaje(new File("src\\diccionario2.xml"), 80);
        System.out.println("\nMAPA:");
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(">> " + key + ":" + value);

        }

        // 4.- Contar el número de veces que aparece una palabra (su grafía)
        // en la lista de sinonimos
        
    }

}
