/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_jaxb_albaran;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import jaxb.albaran.Direccion;
import jaxb.albaran.PedidoType;

/**
 *
 * @author Alexis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // Crear una instanacia para poder manipular las clases generadas,
            // que están en el paquete jaxb.albaran
            // Las que creamos con el JAXB Binding
            JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.albaran");

            // Crear un objeto de tipo Unmarshaller para convertir datos XML
            // en un árbol de objetos java
            Unmarshaller u = jaxbContext.createUnmarshaller();

            // La clase JAXBElement representa a un elemento de un documento
            // XML en este caso a un elemento del tipo albaran.xml
            JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("src\\albaran.xml"));

            // El método getValue() retorna el modelo de contenido (content model)
            // y el valor de los atributos del elemento
            PedidoType pedidoType = (PedidoType) jaxbElement.getValue();

            // Obtenemos una instancia de tipo PedidoType para obtener un
            // Objeto de tipo Dirección
            Direccion direccion = pedidoType.getFacturarA();

            // Establecemos los datos
            direccion.setNombre("Jose Javier");
            direccion.setCalle("Zafiro 3");
            direccion.setCiudad("Oviedo");
            direccion.setProvincia("Asturias");
            direccion.setCodigoPostal(new BigDecimal("33001"));

            // Crear un objeto de tipo Marshaller para posteriormente convertir
            // el árbol de objetos Java a datos XML
            Marshaller m = jaxbContext.createMarshaller();

            // Crear el resultado XML no formateado para lectura de las personas,
            // con saltos de línea, etc
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Escribir el elemento obtenido como primer parámetro por la salida
            // estándar, el segundo parámetro
            m.marshal(jaxbElement, System.out);

        } catch (JAXBException e) {
            System.out.println("Error: " + e.getCause());
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }

    }

}
