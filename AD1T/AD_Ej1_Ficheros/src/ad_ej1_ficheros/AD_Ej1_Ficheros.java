/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej1_ficheros;

import ad_ej1_ficheros.logica.Codificador;
import ad_ej1_ficheros.logica.Filtros;
import ad_ej1_ficheros.logica.OperacionesFicheros;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alexis
 */
public class AD_Ej1_Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos un Obj. OperacionesFicheros
        OperacionesFicheros op = new OperacionesFicheros();

        // 1.- LISTAR DIRECTORIO
        // ---------------------
        // Usamos el método ListarFicheros
        String[] listadoArchivos = op.listarFicheros("", false, true);

        // Mostramos los ficheros
        for (int i = 0; i < listadoArchivos.length; i++) {
            System.out.println(listadoArchivos[i]);

        }

        // 2.- CREAR DIRECTORIOS
        // ---------------------
        // Creamos unos directorios
        // Preparamos un File para usar como rutaOrigen
        File fichero = new File("C:\\");

        // Y un ArrayList de directorios a crear
        ArrayList<String> directorios = new ArrayList<>();
        directorios.add("pruebasAD");
        directorios.add("pruebasAD\\Carpeta1\\Carpeta2");
        directorios.add("pruebasAD\\Carpeta1");
        directorios.add("pruebasAD\\Carpeta22");
        directorios.add("pruebasAD\\Carpeta33");

        // Luego llamamos al método que debe crear...
        int totalDirectoris = op.crearDirectorios(fichero, directorios);

        System.out.println("Se han creado: " + totalDirectoris);

        // 3.- CAMBIAR EXTENSIÓN
        // ---------------------
        System.out.println("Se han modificado: " + op.cambiarExtensionFicheros("C:\\pruebasAD\\", ".txt", ".java") + " ficheros.");

        // 4.- LISTAR RECURSIVO
        // ---------------------
        System.out.println("\nListar recursivamente:\n");
        op.listarRecursivamente("C:\\pruebasAD\\", "");

        // 5.- LISTAR CON FILTROS
        // ---------------------
        System.out.println("\nListar con filtros:\n");
        ArrayList<File> listadoFiltrado = new ArrayList<>();
        listadoFiltrado = op.listarConFiltro("", new Filtros.FiltroExtension(".log"));

        // Mostramos el resultado
        for (File file : listadoFiltrado) {
            System.out.println(file.getName());

        }

        // 6.- CODIFICACIÓN CESAR
        // ---------------------
        System.out.println("\nCodificar ficheros\n");
        op.cifrarArchivos("C:\\pruebasAD\\txt\\", ".txt");
        op.descifrarArchivos("C:\\pruebasAD\\txt\\", ".txt");

    }

}
