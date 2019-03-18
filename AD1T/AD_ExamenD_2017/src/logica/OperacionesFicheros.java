/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.CarpetaVacia;
import excepciones.NoEsUnDirectorioNoSePuedeListar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class OperacionesFicheros {

    /**
     * Devuelve un listado de archivos aplicando un filtro.
     *
     * @param filtro
     * @return
     */
    public ArrayList<File> listarConFiltro(String ruta, FilenameFilter filtro) {

        // Variable donde almacenaremos el contenido del directorio
        String[] listado = null;
        ArrayList<File> listaFicheros = new ArrayList<>();

        // Si la ruta está vacía buscará en la raíz en función del OS.
        if (ruta.equals("")) {

            // If Windows OS.
            if (File.separator.equals("\\")) {
                ruta = "C:\\";
            } else {
                ruta = "/.";
            }

        }

        try {

            // Obtenemos el listado de los ficheros de la ruta
            File fichero = new File(ruta);

            // Comprobamos que sea un directorio
            // Si no lo es, lanzamos una excepción
            if (!fichero.isDirectory()) {
                throw new NoEsUnDirectorioNoSePuedeListar();
            }

            // Cargamos el contenido completo del directorio            
            listado = fichero.list();

            // Comprobamos que la carpeta no esté vacía
            // Si lo está, lanzamos una excepción
            if (listado.length == 0) {
                throw new CarpetaVacia();
            }

            // Filtramos el listado
            listado = fichero.list(filtro);

        } catch (NoEsUnDirectorioNoSePuedeListar ex) {
            System.out.println(ex.excErrorNoEsDir());

        } catch (CarpetaVacia ex) {
            System.out.println(ex.excErrorEmpty());
        }

        // Convertimos el listado a ArrayList y luego
        // Retornamos el ArrayList<File>
        for (String f : listado) {

            // Creamos un Obj. File
            File file = new File(f);

            // Lo añadimos
            listaFicheros.add(file);

        }

        return listaFicheros;

    }

    /**
     * Busca errores en un listado de Ficheros y los guarda en un nuevo archivo
     *
     * @param ruta
     * @param listadoFiltrado
     * @param nombreFileErrores
     */
    public void buscarErrores(String ruta, ArrayList<File> listadoFiltrado, File fileErrores) {

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String linea;
        boolean contieneErrores;

        try {

            // Apertura del fichero y creación del BufferWritter
            fw = new FileWriter(fileErrores);
            bw = new BufferedWriter(fw);

            // Recorremos los distintos ficheros
            for (File f : listadoFiltrado) {

                System.out.println("\n>> Trabajando en fichero: " + ruta + f.getName());

                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                fr = new FileReader(ruta + f);
                br = new BufferedReader(fr);

                // Lectura del fichero línea a línea
                // Recorremos las LINEAS
                br.readLine(); // Quitamos la primera línea
                while ((linea = br.readLine()) != null) {

                    // Variable de control
                    contieneErrores = false;

                    // Limpiamos la línea de espacios
                    linea = linea.replace(" ", "");

                    // La dividimos en items
                    String[] elementos = linea.split(",");

                    // Comprobamos que existan 4 elementos en al LINEA
                    if (elementos.length == 4) {

                        // Recorremos los ELEMENTOS de la LINEA
                        for (int i = 0; i < elementos.length; i++) {

                            // Comprobamos que el elemento no esté vacio
                            if (!elementos[i].equals("")) {

                                // Si es el DNI
                                // Comprobamos que esté bien formado
                                if (elementos[i] == elementos[2]) {
                                    if (!compruebaDNI(elementos[i])) {
                                        // Error: El DNI no es válido
                                        contieneErrores = true;

                                    }
                                }

                                // Si es el Teléfono
                                // Comprobamos que esté bien formado
                                if (elementos[i] == elementos[3]) {
                                    if (!compruebaTlf(elementos[i])) {
                                        // Error: El Tlf. no es válido
                                        // Guardamos la línea en el archivo de errores
                                        contieneErrores = true;

                                    }
                                }

                            } else {
                                // Error: Uno de los elementos está vacio
                                System.out.println("Elemento vacio");
                                contieneErrores = true;

                            }

                        }

                    } else {
                        // Error: Falta algún elemento
                        contieneErrores = true;

                    }

                    // Si se han encontrado errores, guardamos la línea
                    if (contieneErrores) {
                        // Escribimos la línea en el fichero
                        bw.write(linea);

                        // Creamos un salto de línea
                        bw.newLine();

                    }

                }

                // Persistimos el fichero
                bw.flush();

            }

        } catch (IOException e) {
            System.out.println("Error leyendo fichero: " + e);

        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println("Error: " + e2);

            }
        }

    }

    /**
     * Comprueba que un DNI está bien formado
     *
     * @param dni
     * @return
     */
    private boolean compruebaDNI(String dni) {
        String numero = "";
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean esNumero;

        // Comprobamos la longitud
        if (dni.length() != 9) {
            System.out.println("Error número < 9. DNI Length = " + dni.length());
            return false;

        }

        // Comprobamos que el último caracter sea una letra
        if (!Character.isLetter(dni.charAt(8))) {
            System.out.println("Error letra final.");
            return false;

        }

        // Comprobamos que los primeros caracteres son números
        for (int i = 0; i < dni.length() - 1; i++) {

            // Capturamos solo el número i del String dni
            numero = dni.substring(i, i + 1);

            // Recorremos el array de números válidos
            // Buscando un positivo
            esNumero = false;   // Reseteamos la variable de control

            for (int j = 0; j < numeros.length; j++) {
                if (numero.equals(numeros[j])) {
                    // Se ha encontrado una coincidencia
                    esNumero = true;
                }

            }

            // Comprobamos si se ha encontrado una coincidencia
            if (!esNumero) {
                return false;
            }

        }

        // Si no se han encontrado errores
        // Devolvemos true
        return true;

    }

    /**
     * Comprueba que un tlf. esté bien formado
     *
     * @param elemento
     * @return
     */
    private boolean compruebaTlf(String elemento) {

        // Si tiene 9 cifras...
        if (elemento.length() == 9) {

            // Y empieza por 6 o 9 ...
            if (elemento.charAt(0) == '6' || elemento.charAt(0) == '9') {
                return true;

            } else {
                System.out.println("Empieza por: " + elemento.charAt(0));
            }

        } else {
            System.out.println("Tlf tiene: " + elemento.length() + " cifras");
        }

        return false;
    }

}
