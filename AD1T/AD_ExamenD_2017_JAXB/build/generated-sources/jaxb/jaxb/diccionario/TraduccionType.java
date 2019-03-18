//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.17 a las 11:25:19 PM CET 
//


package jaxb.diccionario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para traduccionType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="traduccionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idiomaTraduccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grafia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fonetica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traduccionType", propOrder = {
    "idiomaTraduccion",
    "grafia",
    "fonetica"
})
public class TraduccionType {

    @XmlElement(required = true)
    protected String idiomaTraduccion;
    @XmlElement(required = true)
    protected String grafia;
    @XmlElement(required = true)
    protected String fonetica;

    /**
     * Obtiene el valor de la propiedad idiomaTraduccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdiomaTraduccion() {
        return idiomaTraduccion;
    }

    /**
     * Define el valor de la propiedad idiomaTraduccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdiomaTraduccion(String value) {
        this.idiomaTraduccion = value;
    }

    /**
     * Obtiene el valor de la propiedad grafia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrafia() {
        return grafia;
    }

    /**
     * Define el valor de la propiedad grafia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrafia(String value) {
        this.grafia = value;
    }

    /**
     * Obtiene el valor de la propiedad fonetica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonetica() {
        return fonetica;
    }

    /**
     * Define el valor de la propiedad fonetica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonetica(String value) {
        this.fonetica = value;
    }

}
