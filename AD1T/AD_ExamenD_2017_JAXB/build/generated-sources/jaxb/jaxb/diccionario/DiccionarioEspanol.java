//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.17 a las 11:25:19 PM CET 
//


package jaxb.diccionario;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="palabras">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="palabra" type="{}palabraType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "palabras"
})
@XmlRootElement(name = "diccionarioEspanol")
public class DiccionarioEspanol {

    @XmlElement(required = true)
    protected DiccionarioEspanol.Palabras palabras;

    /**
     * Obtiene el valor de la propiedad palabras.
     * 
     * @return
     *     possible object is
     *     {@link DiccionarioEspanol.Palabras }
     *     
     */
    public DiccionarioEspanol.Palabras getPalabras() {
        return palabras;
    }

    /**
     * Define el valor de la propiedad palabras.
     * 
     * @param value
     *     allowed object is
     *     {@link DiccionarioEspanol.Palabras }
     *     
     */
    public void setPalabras(DiccionarioEspanol.Palabras value) {
        this.palabras = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="palabra" type="{}palabraType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "palabra"
    })
    public static class Palabras {

        @XmlElement(required = true)
        protected List<PalabraType> palabra;

        /**
         * Gets the value of the palabra property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the palabra property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPalabra().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PalabraType }
         * 
         * 
         */
        public List<PalabraType> getPalabra() {
            if (palabra == null) {
                palabra = new ArrayList<PalabraType>();
            }
            return this.palabra;
        }

    }

}
