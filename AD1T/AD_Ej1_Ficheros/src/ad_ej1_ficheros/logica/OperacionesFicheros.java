/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej1_ficheros.logica;

import ad_ej1_ficheros.exceptions.CarpetaVacia;
import ad_ej1_ficheros.exceptions.DirectorioYaExiste;
import ad_ej1_ficheros.exceptions.NoEsUnDirectorioNoSePuedeListar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class OperacionesFicheros {

    public OperacionesFicheros() {
    }

    /**
     * Lista los ficheros de un directorio. Si no se le pasa ruta, cargará el
     * raiz, ya sea windows o linux Por defecto muestra todo el contenido,
     * además permite ordenar por tamaño y mostrar el tamaño de los ficheros o
     * mostrar solo directorios.
     *
     * @param ruta
     * @param ordenadosPorTamano
     * @param soloDirectorios
     * @return
     */
    public String[] listarFicheros(String ruta, boolean ordenadosPorTamano, boolean soloDirectorios) {

        // Variable donde almacenaremos el contenido del directorio
        String[] listado = null;

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

            // Si ordenadoPorTamano es True, retornamos los nombres y tamaño
            // ordenador por tamaño
            if (ordenadosPorTamano) {

                // Listamos los ficheros
                File[] arrayFiles = fichero.listFiles();

                // Transforma array en lista
                List<File> listaFicheros = Arrays.asList(arrayFiles);

                // Ordenamos
                Collections.sort(listaFicheros, (File f1, File f2) -> f1.length() < f2.length() ? 1 : -1);

                System.out.println("Lista ordenada por tamaño.");

                // Recorremos el listado, formateandolo para añadir el tamaño 
                for (int i = 0; i < listado.length; i++) {
                    listado[i] = listaFicheros.get(i).toString() + " ( " + (listaFicheros.get(i).length() / 1024) + " KB) ";

                }

            }

            // Si soloDirectorios es true retornará solo los nombres de los directorios
            if (soloDirectorios) {

                // Filtramos 
                //System.out.println("\nLista solo Directorios");
                listado = fichero.list(new Filtros.FiltroSoloDirectorios());

            }

        } catch (NoEsUnDirectorioNoSePuedeListar ex) {
            System.out.println(ex.excErrorNoEsDir());

        } catch (CarpetaVacia ex) {
            System.out.println(ex.excErrorEmpty());
        }

        // Sino, devolvemos el listado completo
        return listado;

    }

    /**
     * Lista recursivamente un directorio
     *
     * @param ruta
     * @return
     */
    public void listarRecursivamente(String ruta, String tabulacion) {

        // Variable donde almacenaremos el contenido del directorio
        File[] listado = null;

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
            listado = fichero.listFiles();

            // Lo recorremos
            // Si llegamos a un directorio, lo recorreremos antes de continuar
            for (File f : listado) {

                // Mostramos el nombre de f
                System.out.println(tabulacion + f.getAbsoluteFile());

                // Si es un directorio, entramos y lo recorremos
                if (f.isDirectory()) {
                    this.listarRecursivamente(f.getAbsolutePath(), tabulacion + "--");
                }

            }

        } catch (NoEsUnDirectorioNoSePuedeListar ex) {
            System.out.println(ex.excErrorNoEsDir());

        }

    }

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
        //listaFicheros.addAll(Arrays.asList(listado));
        for (String f : listado) {

            // Creamos un Obj. File
            File file = new File(f);

            // Lo añadimos
            listaFicheros.add(file);

        }

        return listaFicheros;

    }

    /**
     * Crea un listado de directorios en un ruta origen Si el directorio existe,
     * saltará una excepción. Si la ruta no existe muestra una excepción.
     * Devuelve el número de directorios creados
     *
     * @param rutaOrigen
     * @param listaDirectorios
     * @return
     */
    public int crearDirectorios(File rutaOrigen, ArrayList<String> listaDirectorios) {

        int totalDirectoriosCreados = 0;

        try {

            // Obtenemos el listado de los ficheros de la ruta
            File fichero = rutaOrigen;

            // Comprobamos que sea un directorio
            // Si no lo es, lanzamos una excepción
            if (!fichero.isDirectory()) {
                throw new NoEsUnDirectorioNoSePuedeListar();
            }

            // Creamos los directorios
            // Nos llegará un ArrayList<String> así que lo recorremos
            for (String directorio : listaDirectorios) {

                // Intentamos crearlo
                try {

                    boolean exito = (new File(rutaOrigen + directorio)).mkdirs();

                    if (!exito) {
                        throw new DirectorioYaExiste(directorio);
                    } else {
                        totalDirectoriosCreados++;
                        System.out.println("Creado con éxito: " + rutaOrigen + directorio);
                    }

                } catch (DirectorioYaExiste ex) {
                    System.out.println(ex.exErrorDirYaExiste());

                }

            }

        } catch (NoEsUnDirectorioNoSePuedeListar ex) {
            System.out.println(ex.excErrorNoEsDir());

        }

        return totalDirectoriosCreados;

    }

    /**
     * Modifica la extensión de todos los archivos de una ruta dada. Y retorna
     * el número de ficheros modificados.
     *
     * @param ruta
     * @param extensionAntigua
     * @param extensionNueva
     * @return
     */
    public int cambiarExtensionFicheros(String ruta, String extensionAntigua, String extensionNueva) {

        int totalArchivosModificados = 0;

        try {
            // Creamos el Obj. que hace ref. al fichero
            File fichero = new File(ruta);

            // Comprobamos que sea un directorio
            // Si no lo es, lanzamos una excepción
            if (!fichero.isDirectory()) {
                throw new NoEsUnDirectorioNoSePuedeListar();
            }

            // Listamos el directorio con un Filtro. 
            // Solo queremos los archivos con extensión "extensionAntigua"
            String[] listado = fichero.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {

                    if (name.endsWith(extensionAntigua)) {
                        return true;
                    }

                    return false;

                }
            });

            System.out.println(">> Se han encontrado (" + listado.length + ") ficheros para renombrar...");

            // Recorremos el listado de archivos creado
            // Y les vamos cambiando la extensión
            for (String f : listado) {

                // Obj. del fichero original
                File f1 = new File(ruta + f);

                // Obj. del nuevo fichero 
                File f2 = new File(ruta + f1.getName().replace(extensionAntigua, extensionNueva));

                // Renombramos físicamente
                if (f1.renameTo(f2)) {
                    totalArchivosModificados++;
                }

            }

        } catch (NoEsUnDirectorioNoSePuedeListar ex) {
            System.out.println(ex.excErrorNoEsDir());

        }

        return totalArchivosModificados;
    }

    public void cifrarArchivos(String ruta, String ext) {

        Codificador codificador = new Codificador();

        // Buscamos todos los ficheros con extensión ext
        ArrayList<File> listadoFiltrado = listarConFiltro(ruta, new Filtros.FiltroExtension(ext));

        // Recorremos los ficheros cifrando su contenido
        for (File file : listadoFiltrado) {

            // Extraemos el texto del fichero
            System.out.println(">> Leyendo " + file.getName());
            String txtOriginal = leerFileInputStream(ruta + file.getName());

            // Lo codificamos
            System.out.println("Codificando...");
            String textoCifrado = codificador.cifrar(txtOriginal);

            // Guardamos los cambios en el fichero            
            System.out.println("Guardado cambios...");
            if (escribirFileOutputStream(ruta + file.getName(), textoCifrado)) {
                System.out.println("Cofificación terminada con éxito.");

            }

        }

    }

    public void descifrarArchivos(String ruta, String ext) {

        Codificador codificador = new Codificador();

        // Buscamos todos los ficheros con extensión ext
        ArrayList<File> listadoFiltrado = listarConFiltro(ruta, new Filtros.FiltroExtension(ext));

        // Recorremos los ficheros cifrando su contenido
        for (File file : listadoFiltrado) {

            // Extraemos el texto del fichero
            System.out.println(">> Leyendo " + file.getName());
            String txtOriginal = leerFileInputStream(ruta + file.getName());

            // Lo codificamos
            System.out.println("Descodificando...");
            String textoCifrado = codificador.descifrar(txtOriginal);

            // Guardamos los cambios en el fichero            
            System.out.println("Guardado cambios...");
            if (escribirFileOutputStream(ruta + file.getName(), textoCifrado)) {
                System.out.println("Descodificación terminada con éxito.");

            }

        }

    }

    public String leerFileInputStream(String ruta) {

        // Texto que vamos a devolver
        String texto = "";

        try (FileInputStream fis = new FileInputStream(ruta)) {

            int valor = fis.read();

            while (valor != -1) {
                texto += ((char) valor);
                valor = fis.read();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

        }

        return texto;

    }

    public boolean escribirFileOutputStream(String ruta, String s) {

        try (FileOutputStream fos = new FileOutputStream(ruta)) {

            String texto = s;

            // Copiamos el texto en un array de bytes
            byte codigos[] = texto.getBytes();

            // Escribimos en el archivo
            fos.write(codigos);

            // Retornamos exito
            return true;

        } catch (IOException e) {
            System.out.println("Error: " + e);

        }

        return false;

    }

}
