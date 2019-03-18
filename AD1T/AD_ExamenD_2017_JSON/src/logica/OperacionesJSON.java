/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import excepciones.FicheroJsonExcepcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import pruebas.Main;

/**
 *
 * @author Alexis
 */
public class OperacionesJSON {

    /**
     * Lee un fichero JSON y retorna un listado de palabras
     *
     * @return
     * @throws FicheroJsonExcepcion
     */
    public JsonArray getListadoPalabras(File f) throws FicheroJsonExcepcion {

        try {
            // Leemos el JSON
            FileReader fr = new FileReader(f);
            JsonReader jsonReader = Json.createReader(fr);
            JsonObject objetoPadre = jsonReader.readObject();
            fr.close();

            // Cargamos el Jsonarray
            JsonArray listaPalabras = objetoPadre.getJsonObject("diccionarioEspanol").getJsonObject("palabras").getJsonArray("palabra");

            if (listaPalabras == null || listaPalabras.isEmpty()) {
                throw new FicheroJsonExcepcion("El fichero Json está mal formado");
            }

            return listaPalabras;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    /**
     * Busca el total de sinonimos y antonimos de una palabra dada en el arbol
     * JSON
     *
     * @param f fichero JSON
     * @param palabra Palabra de la que queremos buscar sinonimos/antonimos
     * @return array int[]
     */
    public int[] getTotalSinonimosAntonimosOf(File f, String palabra) {

        int[] sinonimosAntonimos = new int[2];

        try {
            // Lo primero es cargar un array con todas las palabras del JSON
            JsonArray listadoPalabras = getListadoPalabras(f);

            // Recorremos el listado
            for (JsonValue p : listadoPalabras) {

                // COnvertimos p a una palabraLegible
                JsonObject palabraLegible = (JsonObject) p;

                // Buscamos la palabra indicada
                if (palabraLegible.getJsonString("grafia").getString().equalsIgnoreCase(palabra)) {

                    sinonimosAntonimos[0] = palabraLegible.getJsonObject("sinonimos").getJsonArray("sinonimo").size();
                    sinonimosAntonimos[1] = palabraLegible.getJsonObject("antonimos").getJsonArray("antonimo").size();
                    break;

                }

            }

        } catch (Exception e) {

        }

        return sinonimosAntonimos;

    }

    /**
     * Genera un Map<k,v> donde k es la palabra y v es el total de sinonimos con
     * una similitud > a la variable porcentaje
     *
     * @param ficheroJson
     * @param porcentaje
     * @return
     */
    public Map<String, Integer> obtenerSinonimosSuperioresPorcentaje(File ficheroJson, double porcentaje) {

        // Creo el mapa
        Map<String, Integer> grafiasConSinonimosSuperioresA = new HashMap<>();

        try {

            // Cargamos la lista de palabras
            JsonArray listadoPalabras = getListadoPalabras(ficheroJson);

            // Recorremos las palabras
            for (JsonValue p : listadoPalabras) {

                // Convertimos p a una palabraLegible
                JsonObject palabraLegible = (JsonObject) p;

                // Recuperamos el listado de sinonimos de la palabra
                JsonArray listaSinonimos = palabraLegible.getJsonObject("sinonimos").getJsonArray("sinonimo");

                // Añadimos la palabra al Map
                String valorPalabra = palabraLegible.getJsonString("grafia").toString();
                grafiasConSinonimosSuperioresA.put(valorPalabra, 0);

                // Commprobamos si alguno tiene un porcentaje superior al deseado
                for (JsonValue unSinonimo : listaSinonimos) {

                    JsonObject sinonimoLegible = (JsonObject) unSinonimo;

                    if (sinonimoLegible.getJsonNumber("porcentajeSimilitud").doubleValue() > porcentaje) {

                        // Lo añadimos al mapa
                        int valorActual = grafiasConSinonimosSuperioresA.get(valorPalabra);
                        grafiasConSinonimosSuperioresA.replace(valorPalabra, valorActual + 1);

                    }
                }

            }

        } catch (FicheroJsonExcepcion ex) {
            Logger.getLogger(OperacionesJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return grafiasConSinonimosSuperioresA;

    }

    /**
     * Lee un fichero JSON y retorna un listado de las últimas palabras añadidas
     *
     * @param f
     * @param fechaCorte
     * @param ficheroSalida
     * @return
     * @throws FicheroJsonExcepcion
     */
    public void generarJsonConPalabrasPorFechaReciente(File f, Date fechaCorte, File ficheroSalida) throws FicheroJsonExcepcion {

        // Creamos un array donde guardar las palabras nuevas
        JsonArrayBuilder arrayPalabrasNuevas = Json.createArrayBuilder();

        // Formateador fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Leemos el JSON
            FileReader fr = new FileReader(f);
            JsonReader jsonReader = Json.createReader(fr);
            JsonObject objetoPadre = jsonReader.readObject();
            fr.close();

            // Cargamos el Jsonarray
            JsonArray listaPalabras = objetoPadre.getJsonObject("diccionarioEspanol").getJsonObject("palabras").getJsonArray("palabra");

            if (listaPalabras == null || listaPalabras.isEmpty()) {
                throw new FicheroJsonExcepcion("El fichero Json está mal formado");
            }

            // Recorremos las palabras
            for (JsonValue unaPalabra : listaPalabras) {

                // Comprobamos si es una palabra válida
                // Si lo es, la añadimos al arrayPalabrasNuevas
                try {
                    JsonObject unaPalabraLegible = (JsonObject) unaPalabra;
                    Date fechaPalabra = sdf.parse(unaPalabraLegible.getJsonString("fechaInsercion").getString());
                    if (Math.abs(Math.abs(fechaCorte.getTime()) - Math.abs(fechaPalabra.getTime())) < (3 * 24 * 60 * 60 * 1000)) {
                        arrayPalabrasNuevas.add(unaPalabra);
                    }
                } catch (ParseException ex) {
                    System.out.println("Error al formatear la fecha");
                }

            }

            // Grabamos el fichero JSON nuevo
            grabarJson(arrayPalabrasNuevas.build(), ficheroSalida);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Graba un array de objeto Json en un fichero editable.
     *
     * @param unArray array cerrado de objetos Json
     * @param ficheroSalida fichero donde se volcarán los datos
     * @return fichero grabado
     */
    private File grabarJson(JsonArray unArray, File ficheroSalida) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(ficheroSalida);
            JsonWriter jw = Json.createWriter(fw);  //objeto de factoría
            jw.writeArray(unArray);
            jw.close();
        } catch (IOException e) {
            System.out.println("Algún error durante la grabación");
        } finally {
            return ficheroSalida;
        }
    }
}
