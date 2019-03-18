/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.File;
import java.util.ArrayList;
import logica.Filtros;
import logica.OperacionesFicheros;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String ruta = "C:\\pruebasAD\\";

        // Instanciamos la clase manejadora de Ficheros
        OperacionesFicheros op = new OperacionesFicheros();

        // 1.- Buscamos los ficheros .TXT
        // ---------------------
        ArrayList<File> listadoFiltrado = new ArrayList<>();
        listadoFiltrado = op.listarConFiltro(ruta, new Filtros.FiltroExtensionEmpiezaVocal(".txt"));

        // 2.- Usando el listado de ficheros
        // Leemos línea a línea buscando errores
        // Los errores se copiaran a un nuevo fichero
        op.buscarErrores(ruta, listadoFiltrado, new File(ruta + "errores.txt"));

    }

}
