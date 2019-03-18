//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.16 a las 10:36:28 PM CET 
//


package jaxb.albaran;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para PedidoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PedidoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="facturarA" type="{}Direccion"/>
 *         &lt;element ref="{}comentario" minOccurs="0"/>
 *         &lt;element name="articulos" type="{}Articulos"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fechaPedido" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PedidoType", propOrder = {
    "facturarA",
    "comentario",
    "articulos"
})
public class PedidoType {

    @XmlElement(required = true)
    protected Direccion facturarA;
    protected String comentario;
    @XmlElement(required = true)
    protected Articulos articulos;
    @XmlAttribute(name = "fechaPedido")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPedido;

    /**
     * Obtiene el valor de la propiedad facturarA.
     * 
     * @return
     *     possible object is
     *     {@link Direccion }
     *     
     */
    public Direccion getFacturarA() {
        return facturarA;
    }

    /**
     * Define el valor de la propiedad facturarA.
     * 
     * @param value
     *     allowed object is
     *     {@link Direccion }
     *     
     */
    public void setFacturarA(Direccion value) {
        this.facturarA = value;
    }

    /**
     * Obtiene el valor de la propiedad comentario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define el valor de la propiedad comentario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentario(String value) {
        this.comentario = value;
    }

    /**
     * Obtiene el valor de la propiedad articulos.
     * 
     * @return
     *     possible object is
     *     {@link Articulos }
     *     
     */
    public Articulos getArticulos() {
        return articulos;
    }

    /**
     * Define el valor de la propiedad articulos.
     * 
     * @param value
     *     allowed object is
     *     {@link Articulos }
     *     
     */
    public void setArticulos(Articulos value) {
        this.articulos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPedido.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPedido() {
        return fechaPedido;
    }

    /**
     * Define el valor de la propiedad fechaPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPedido(XMLGregorianCalendar value) {
        this.fechaPedido = value;
    }

}
