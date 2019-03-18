/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej2_quijote.logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Alexis
 */
public class OperacionesFicheros {

    /**
     * Devuelve el número de líneas de un fichero.
     *
     * @param f
     * @return
     */
    public int contarLineas(File f) {

        FileReader fr = null;
        BufferedReader br = null;
        int totalLineas = 0;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            // Lectura del fichero
            while (br.readLine() != null) {
                totalLineas++;

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

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

        return totalLineas;

    }

    /**
     * Devuelve el número de palabras de un fichero
     *
     * @param f
     * @return
     */
    public int contarPalabras(File f) {
        FileReader fr = null;
        BufferedReader br = null;
        int totalPalabras = 0;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            // Lectura del fichero
            while ((linea = br.readLine()) != null) {
                // Cada línea la partimos en tokens
                // Cada token en una palabra
                for (StringTokenizer token = new StringTokenizer(linea); token.hasMoreTokens();) {
                    String palabra = token.nextToken();
                    totalPalabras++;

                }

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

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

        return totalPalabras;
    }

    /**
     * Devuelve el número de veces que aparece una palabra repetida en un
     * fichero.
     *
     * @param f Fichero en el que vamos a buscar
     * @param keyword Palabra clave que queremos buscar
     * @return total de repeticiones de la keyword en el fichero
     */
    public int contarPalabra(File f, String keyword) {

        FileReader fr = null;
        BufferedReader br = null;
        int totalRepeticiones = 0;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;
            int contador = 0;

            // Lectura del fichero
            while ((linea = br.readLine()) != null) {
                // Cada línea la partimos en tokens
                // Cada token en una palabra
                for (StringTokenizer token = new StringTokenizer(linea); token.hasMoreTokens();) {
                    String palabra = token.nextToken();
                    if (palabra.toLowerCase().equals(keyword.toLowerCase())) {
                        totalRepeticiones++;
                    }

                }

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

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

        return totalRepeticiones;

    }

    /**
     * Retorna el número de letras de un fichero.
     *
     * @param f
     * @return
     */
    public int contarLetras(File f) {
        FileReader fr = null;
        BufferedReader br = null;
        int totalLetras = 0;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            int caracter;

            // Lectura del fichero
            while ((caracter = br.read()) != -1) {
                // Para cada caracter, comprobamos que sea una letra
                if (Character.isLetter(caracter)) {
                    totalLetras++;
                }

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

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

        return totalLetras;
    }

    /**
     * Crea una fichero a partir de otro, escribiendo su contenido al revés.
     *
     * @param fOriginal
     * @param fNuevo
     * @return
     */
    public boolean crearFicheroAlReves(File fOriginal, File fNuevo) {

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String linea;
        String lineaAlReves;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(fOriginal);
            br = new BufferedReader(fr);

            // Apertura del fichero y creación del BufferWritter
            fw = new FileWriter(fNuevo);
            bw = new BufferedWriter(fw);

            // Lectura del fichero
            while ((linea = br.readLine()) != null) {

                // En cada iteración, variamos la variable
                lineaAlReves = "";

                // En cada línea, recorremos los caracteres
                // desde el último al primero
                for (int i = linea.length() - 1; i >= 0; i--) {

                    // Guardamos el contenido, al reves
                    lineaAlReves += linea.charAt(i);

                }

                // Una vez guardados los caracteres en orden inverso
                // Escribimos la línea en el fichero
                bw.write(lineaAlReves);

                // Creamos un salto de línea
                bw.newLine();

                // Persistimos la línea en el fichero
                bw.flush();

            }

            return true;

        } catch (IOException e) {
            System.out.println("Error: " + e);

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

        return false;

    }

    /**
     * Muestra un listado de las diferentes palabras que hay en un fichero y las
     * veces que se repiten.
     *
     * @param f
     */
    public void verPalabrasContando(File f) {

        FileReader fr = null;
        BufferedReader br = null;
        Map<String, Integer> mapaOrdenado = new TreeMap();
        String caracteresEliminar = "\"()!¡¿?.,:;";
        char caracterEliminar;

        try {

            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            // Lectura del fichero
            while ((linea = br.readLine()) != null) {
                // Para cada línea, recorremos sus palabras
                for (StringTokenizer token = new StringTokenizer(linea); token.hasMoreTokens();) {
                    // Capturamos la palabra
                    String palabra = token.nextToken();

                    // Limpiamos la palabra
                    // Elimina signos de puntuación.
                    for (int i = 0; i < caracteresEliminar.length(); i++) {
                        caracterEliminar = caracteresEliminar.charAt(i);
                        palabra = palabra.replace(caracterEliminar, ' ').toLowerCase().trim();
                    }
                    palabra = palabra.replace(caracteresEliminar, " ").toLowerCase().trim();

                    // Comprobamos si la palabra existe en el arreglo
                    if (mapaOrdenado.containsKey(palabra)) {
                        // Si existe, tomamos el Value y lo incrementamos en 1
                        int repeticiones = mapaOrdenado.get(palabra);

                        // Guardamos la palabra actualizada
                        mapaOrdenado.put(palabra, repeticiones + 1);

                    } else {
                        // Si la palabra no existe, la añadimos
                        mapaOrdenado.put(palabra, 1);

                    }
                }

            }

            // Ahora mostramos el resultado
            for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                System.out.println(">> " + key + ": " + value);

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);

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
     * Divide un fichero en capítulos
     *
     * @param f
     * @return
     */
    public boolean dividirEnCapitulos(File f, String palabraClave) {

        FileReader fr = null;
        BufferedReader br = null;
        int nCapitulo = 0;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            // Archivos que vamos a crear y escribir
            // fw y bw para poder grabar el contenido
            File archivo = new File("capitulos/Capitulo " + nCapitulo + ".txt");
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);

            // Leemos el documento línea a línea
            while ((linea = br.readLine()) != null) {

                // En cada iteración buscamos la palabra clave
                if (linea.contains(palabraClave)) {
                    // Guardamos todo 
                    bw.close();
                    System.out.println("Guardando.. Capitulo " + nCapitulo);

                    // Incrementamos el nº del Capitulo
                    nCapitulo++;

                    // Referenciamos el siguiente fichero
                    // Y cargamos esa referencia en el fw y bw
                    // para poder escribir en él.
                    archivo = new File("capitulos/Capitulo " + nCapitulo + ".txt");
                    fw = new FileWriter(archivo);
                    bw = new BufferedWriter(fw);

                }

                // Grabamos la línea
                // Debe ir aquí porque primero debemos comprobar
                // si estamos terminando/comenzando un capítulo y así
                // cambiar de fichero.
                bw.write(linea);

            }
            
            return true;

        } catch (IOException e) {
            System.out.println("Error: " + e);
            
        }
        
        return false;
        
    }

}
