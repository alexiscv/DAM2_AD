//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.16 a las 10:36:28 PM CET 
//


package jaxb.albaran;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.albaran package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Pedido_QNAME = new QName("", "pedido");
    private final static QName _Comentario_QNAME = new QName("", "comentario");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.albaran
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Articulos }
     * 
     */
    public Articulos createArticulos() {
        return new Articulos();
    }

    /**
     * Create an instance of {@link PedidoType }
     * 
     */
    public PedidoType createPedidoType() {
        return new PedidoType();
    }

    /**
     * Create an instance of {@link Direccion }
     * 
     */
    public Direccion createDireccion() {
        return new Direccion();
    }

    /**
     * Create an instance of {@link Articulos.Articulo }
     * 
     */
    public Articulos.Articulo createArticulosArticulo() {
        return new Articulos.Articulo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PedidoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pedido")
    public JAXBElement<PedidoType> createPedido(PedidoType value) {
        return new JAXBElement<PedidoType>(_Pedido_QNAME, PedidoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "comentario")
    public JAXBElement<String> createComentario(String value) {
        return new JAXBElement<String>(_Comentario_QNAME, String.class, null, value);
    }

}
