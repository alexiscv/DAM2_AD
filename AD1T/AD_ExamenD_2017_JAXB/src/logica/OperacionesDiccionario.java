/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import jaxb.diccionario.AntonimoType;
import jaxb.diccionario.DiccionarioEspanol;
import jaxb.diccionario.PalabraType;
import jaxb.diccionario.PalabraType.Antonimos;
import jaxb.diccionario.PalabraType.Sinonimos;
import jaxb.diccionario.SinonimoType;

/**
 *
 * @author Alexis
 */
public class OperacionesDiccionario {

    /**
     * Realiza la operación Unmarshaller. Consiste en convertir datos XML en un
     * árbol de objetos Java.
     *
     * @param archivo
     * @return JAXBElement
     */
    public JAXBElement unmarshalizar(File ficheroXml) {

        // El obj. que vamos a devolver.
        JAXBElement objetoPadreJaxb = null;

        try {
            // Crear una instanacia para poder manipular las clases generadas,
            // que están en el paquete jaxb.diccionario
            // Las que creamos con el JAXB Binding
            JAXBContext jaxbCtx = JAXBContext.newInstance("jaxb.diccionario");

            // Crear un objeto de tipo Unmarshaller para convertir datos XML
            // en un árbol de objetos java
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            // La clase JAXBElement representa a un elemento de un documento
            // XML en este caso a un elemento del tipo diccionario2.xml
            objetoPadreJaxb = (JAXBElement) unmarshaller.unmarshal(new StreamSource(ficheroXml), DiccionarioEspanol.class);

        } catch (JAXBException e) {
            System.out.println("Error JAXB: " + e.getCause());

        }

        return objetoPadreJaxb;

    }

    /**
     * Genera un documento con las modificaciones de un objeto Jaxb dado
     *
     * @param objetoPadre elemento con toda la información del documento
     * @param ficheroDestino fichero al que irán a parar los datos en formato
     * legible
     * @return <i>true</i> si todo ha salido bien, <i>false</i> en caso
     * contrario
     */
    private boolean grabarFicheroModificado(JAXBElement objetoPadre, File ficheroDestino) {

        try {
            // Crear una instanacia para poder manipular las clases generadas,
            // que están en el paquete jaxb.diccionario
            // Las que creamos con el JAXB Binding
            JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance("jaxb.diccionario");

            // Crear un objeto de tipo Marshaller para posteriormente convertir
            // el árbol de objetos Java a datos XML
            Marshaller marshaller = jaxbCtx.createMarshaller();

            // Crear el resultado XML no formateado para lectura de las personas,
            // con saltos de línea, etc
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Escribir el elemento obtenido como primer parámetro por la salida
            // estándar, el segundo parámetro
            marshaller.marshal(objetoPadre, ficheroDestino);

            // Retorno
            return true;

        } catch (javax.xml.bind.JAXBException ex) {
            // Notifico el error
            System.out.println("Error al marshalizar");

            // Retorno            
            return false;

        }

    }

    public void getTotalSinonimoAntonimosDe(String palabraClave) {

        // Variables donde almacenar los totales
        int sinonimos = 0;
        int antonimos = 0;

        // Unmarshalizar el documento XML
        JAXBElement jaxbElement = unmarshalizar(new File("src\\diccionario2.xml"));

        // Cargamos las palabras desde el DiccionarioEspanol
        DiccionarioEspanol diccionarioPadre = (DiccionarioEspanol) jaxbElement.getValue();

        // Cargamos las palabras en una List usando el Obj. diccionarioPadre
        List<PalabraType> listaPalabras = diccionarioPadre.getPalabras().getPalabra();

        // Recorremos la List
        for (PalabraType palabra : listaPalabras) {

            System.out.println(">> " + palabra.getGrafia());

            // Comprobamos si la palabra, es la indicada
            if (palabra.getGrafia().equals(palabraClave)) {
                // Creamos un List para sinonimos/antonimos
                List<SinonimoType> listaSinonimos = palabra.getSinonimos().getSinonimo();
                List<AntonimoType> listaAntonimos = palabra.getAntonimos().getAntonimo();

                // Contabilizamos los sinonimos/antonimos
                for (SinonimoType sinonimo : listaSinonimos) {
                    sinonimos++;
                }

                for (AntonimoType antonimo : listaAntonimos) {
                    antonimos++;

                }

            }

        }

        System.out.println("\nLa palabra tiene un total de:");
        System.out.println(sinonimos + " sinonimos.");
        System.out.println(antonimos + " antonimos.");

    }

    /**
     * Borra todas las palabras que en su grafía contienen una determinada
     * cadena de caracteres texto.
     *
     * @param cadena
     */
    public void borrarPalabrasQueContiene(String cadena) {

        // Unmarshalizar el documento XML
        JAXBElement jaxbElement = unmarshalizar(new File("src\\diccionario2.xml"));

        // Cargamos las palabras desde el DiccionarioEspanol
        DiccionarioEspanol diccionarioPadre = (DiccionarioEspanol) jaxbElement.getValue();

        // Cargamos las palabras en una List usando el Obj. diccionarioPadre
        List<PalabraType> listaPalabras = diccionarioPadre.getPalabras().getPalabra();

        // Creamos un iterador
        Iterator<PalabraType> iterator = listaPalabras.iterator();

        // Variable que contendrá la palabra iterada
        PalabraType unaPalabra = null;

        // Recorremos la List
        while (iterator.hasNext()) {

            unaPalabra = iterator.next();

            System.out.println(">> " + unaPalabra.getGrafia());

            // Comprobamos si la palabra, debe ser eliminada
            if (unaPalabra.getGrafia().contains(cadena)) {

                // Si es el caso, eliminamos la palabra de la lista
                iterator.remove();

            }

        }

        // Persistimos un XML sin los datos borrados
        grabarFicheroModificado(jaxbElement, new File("src\\diccionarioModificado.xml"));
    }

    /**
     * Retorna un MAP con las palabras y el total de sinonimos que tienen un x%
     * de similitud
     *
     * @param ficheroXml
     * @param porcentaje
     * @return
     */
    public Map<String, Integer> obtenerSinonimosSuperioresPorcentaje(File ficheroXml, double porcentaje) {

        if (porcentaje <= 0.0 || porcentaje >= 100.0) {
            throw new IllegalArgumentException("El porcentaje debe estar contenido entre 0 y 100");
        }

        // Inicializamos el Map
        Map<String, Integer> grafiasConSinonimosSuperioresA = new HashMap<>();

        // Unmarshalizar el documento XML
        JAXBElement jaxbElement = unmarshalizar(new File("src\\diccionario2.xml"));

        // Cargamos las palabras desde el DiccionarioEspanol
        DiccionarioEspanol diccionarioPadre = (DiccionarioEspanol) jaxbElement.getValue();

        // Cargamos las palabras en una List usando el Obj. diccionarioPadre
        List<PalabraType> listaPalabras = diccionarioPadre.getPalabras().getPalabra();

        // Recorremos las palabras
        for (PalabraType unaPalabra : listaPalabras) {

            // Añadimos la palabra al MAP
            grafiasConSinonimosSuperioresA.put(unaPalabra.getGrafia(), 0);

            // Creamos una Lista de los sinonimos de esta palabra
            List<SinonimoType> listaSinonimos = unaPalabra.getSinonimos().getSinonimo();

            // Recorremos la lista
            for (SinonimoType unSinonimo : listaSinonimos) {

                // Comprobamos la similitud
                if (unSinonimo.getPorcentajeSimilitud() > porcentaje) {
                    // Lo añadimos al mapa
                    int valorActual = grafiasConSinonimosSuperioresA.get(unaPalabra.getGrafia());
                    grafiasConSinonimosSuperioresA.replace(unaPalabra.getGrafia(), valorActual + 1);

                }

            }

        }
        return grafiasConSinonimosSuperioresA;

    }

}
