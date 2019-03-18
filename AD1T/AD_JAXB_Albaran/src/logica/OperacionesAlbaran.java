/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import jaxb.albaran.Articulos;
import jaxb.albaran.Direccion;
import jaxb.albaran.PedidoType;

/**
 *
 * @author Alexis
 */
public class OperacionesAlbaran {

    /**
     * Realiza la operación Unmarshaller. Consiste en convertir datos XML en un
     * árbol de objetos Java.
     *
     * @param archivo
     * @return JAXBElement
     */
    public JAXBElement unmarshalizar(String archivo) {

        // El obj. que vamos a devolver.
        JAXBElement jaxbElement = null;

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
            jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream(archivo));

        } catch (JAXBException e) {
            System.out.println("Error JAXB: " + e.getCause());

        } catch (IOException ioe) {
            System.out.println("Error IO: " + ioe.getMessage());
        }

        return jaxbElement;

    }

    public void marshalizar(JAXBElement jaxbElement) {

        try {
            // Crear una instanacia para poder manipular las clases generadas,
            // que están en el paquete jaxb.albaran
            // Las que creamos con el JAXB Binding
            JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.albaran");

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
            System.out.println("Error JAXB: " + e.getCause());

        }

    }

    /**
     * Añadir un artículo nuevo.
     *
     * @param pedidoType
     * @param cantidad
     * @param codigo
     * @param nombre
     * @param precio
     * @param anio
     * @param mes
     * @param dia
     */
    public void addArticulo(PedidoType pedidoType, int cantidad,
            String codigo, String nombre, int precio, int anio, int mes, int dia) {

        // Creamos el Obj.
        Articulos.Articulo articuloNuevo = new Articulos.Articulo();

        // Añadimos sus valores
        articuloNuevo.setCantidad(cantidad);
        articuloNuevo.setCodigo(codigo);
        articuloNuevo.setNombreProducto(nombre);
        articuloNuevo.setPrecio(new BigDecimal(precio));
        try {
            XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            fecha.setYear(anio);
            fecha.setMonth(mes);
            fecha.setDay(dia);
            articuloNuevo.setFechaEnvio(fecha);
        } catch (DatatypeConfigurationException ex) {
            System.err.println("DatatypeConfigurationException");
        }

        // Obtenemos una instancia de tipo PedidoType para obtener un 
        // Objeto de tipo articulos
        Articulos articulos = pedidoType.getArticulos();

        // Cargamos los artículos en una lista
        List<Articulos.Articulo> listaArticulos = articulos.getArticulo();

        // Intentamos añadir nuestro artículo
        try {
            listaArticulos.add(articuloNuevo);

        } catch (UnsupportedOperationException e) {
            System.err.println("UnsupportedOperationException");
        } catch (NullPointerException e) {
            System.err.println("NullPointerException");
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException");
        }

    }

    /**
     * Permite modificar una dirección.
     *
     * @param pedidoType
     * @param nombre
     * @param calle
     * @param ciudad
     * @param provincia
     * @param cp
     */
    public void modDireccion(PedidoType pedidoType, String nombre, String calle, String ciudad, String provincia, BigDecimal cp) {

        // Creamos el Obj. Almacenando los datos actuales de la dirección
        Direccion direccion = pedidoType.getFacturarA();

        // Modificamos los datos
        direccion.setNombre(nombre);
        direccion.setCalle(calle);
        direccion.setCiudad(ciudad);
        direccion.setProvincia(provincia);
        direccion.setCodigoPostal(cp);

    }

    /**
     * Calcula el importe total de un pedido.
     *
     * @param pedidoType
     */
    public void importePedido(PedidoType pedidoType) {

        BigDecimal importeTotal = new BigDecimal(0);

        // Cargamos los artículos desde el pedidoType
        Articulos articulos = pedidoType.getArticulos();

        // Cargamos los articulos en una List usando el Obj. articulos
        List<Articulos.Articulo> listaArticulos = articulos.getArticulo();

        // Recorremos la List
        for (Articulos.Articulo listaArticulo : listaArticulos) {

            // Importe pedido
            BigDecimal importePedido = listaArticulo.getPrecio().multiply(new BigDecimal(listaArticulo.getCantidad()));

            // Sumamos el importe del pedido al total
            importeTotal = importeTotal.add(importePedido);

        }

        System.out.println(">> Total del pedido: " + importeTotal);

    }

    /**
     * Elimina un pedido a partir de su código
     *
     * @param pedidoType
     * @param codigo
     */
    public void borrarArticulo(PedidoType pedidoType, String codigo) {

        // Cargamos los artículos desde el pedidoType
        Articulos articulos = pedidoType.getArticulos();

        // Cargamos los articulos en una List usando el Obj. articulos
        List<Articulos.Articulo> listaArticulos = articulos.getArticulo();

        // Recorremos la List
        for (Articulos.Articulo articulo : listaArticulos) {

            // Buscamos el pedido
            if (articulo.getCodigo().equals(codigo)) {
                listaArticulos.remove(articulo);
                break;
            }

        }

    }

}
