/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import excepciones.FicheroJsonExcepcion;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import logica.OperacionesJSON;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FicheroJsonExcepcion {

        File f = new File("src\\json\\diccionario2.json");
        OperacionesJSON op = new OperacionesJSON();

        // 1.- Contar el número de sinónimos y antónimos de una palabra dada
        String palabra = "String";
        int[] sinonimosAntonimos = op.getTotalSinonimosAntonimosOf(f, palabra);
        System.out.println("Sinonimos de " + palabra + ": " + sinonimosAntonimos[0]);
        System.out.println("Antónimos de " + palabra + ": " + sinonimosAntonimos[1]);

        // 2.- Generar MAP<k,v> con la grafía y el n sinonimos > 80% similitud
        Map<String, Integer> mapa = op.obtenerSinonimosSuperioresPorcentaje(f, 80);

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(">> " + key + ":" + value);

        }

        // 3.- Generar un JSON con las palabras añadidas hace menos de 3 días
        op.generarJsonConPalabrasPorFechaReciente(f, new Date(), new File("src\\json\\palabrasNuevas.json"));
    }

}
