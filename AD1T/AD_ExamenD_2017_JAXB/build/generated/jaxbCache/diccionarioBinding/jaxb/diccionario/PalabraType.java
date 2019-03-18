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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para palabraType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="palabraType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grafia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="definiciones">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="definicion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fechaInsercion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="sinonimos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="sinonimo" type="{}sinonimoType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="antonimos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="antonimo" type="{}antonimoType"/>
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
@XmlType(name = "palabraType", propOrder = {
    "grafia",
    "definiciones",
    "fechaInsercion",
    "sinonimos",
    "antonimos"
})
public class PalabraType {

    @XmlElement(required = true)
    protected String grafia;
    @XmlElement(required = true)
    protected PalabraType.Definiciones definiciones;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaInsercion;
    @XmlElement(required = true)
    protected PalabraType.Sinonimos sinonimos;
    @XmlElement(required = true)
    protected PalabraType.Antonimos antonimos;

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
     * Obtiene el valor de la propiedad definiciones.
     * 
     * @return
     *     possible object is
     *     {@link PalabraType.Definiciones }
     *     
     */
    public PalabraType.Definiciones getDefiniciones() {
        return definiciones;
    }

    /**
     * Define el valor de la propiedad definiciones.
     * 
     * @param value
     *     allowed object is
     *     {@link PalabraType.Definiciones }
     *     
     */
    public void setDefiniciones(PalabraType.Definiciones value) {
        this.definiciones = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInsercion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInsercion() {
        return fechaInsercion;
    }

    /**
     * Define el valor de la propiedad fechaInsercion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInsercion(XMLGregorianCalendar value) {
        this.fechaInsercion = value;
    }

    /**
     * Obtiene el valor de la propiedad sinonimos.
     * 
     * @return
     *     possible object is
     *     {@link PalabraType.Sinonimos }
     *     
     */
    public PalabraType.Sinonimos getSinonimos() {
        return sinonimos;
    }

    /**
     * Define el valor de la propiedad sinonimos.
     * 
     * @param value
     *     allowed object is
     *     {@link PalabraType.Sinonimos }
     *     
     */
    public void setSinonimos(PalabraType.Sinonimos value) {
        this.sinonimos = value;
    }

    /**
     * Obtiene el valor de la propiedad antonimos.
     * 
     * @return
     *     possible object is
     *     {@link PalabraType.Antonimos }
     *     
     */
    public PalabraType.Antonimos getAntonimos() {
        return antonimos;
    }

    /**
     * Define el valor de la propiedad antonimos.
     * 
     * @param value
     *     allowed object is
     *     {@link PalabraType.Antonimos }
     *     
     */
    public void setAntonimos(PalabraType.Antonimos value) {
        this.antonimos = value;
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
     *         &lt;element name="antonimo" type="{}antonimoType"/>
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
        "antonimo"
    })
    public static class Antonimos {

        @XmlElement(required = true)
        protected List<AntonimoType> antonimo;

        /**
         * Gets the value of the antonimo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the antonimo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAntonimo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AntonimoType }
         * 
         * 
         */
        public List<AntonimoType> getAntonimo() {
            if (antonimo == null) {
                antonimo = new ArrayList<AntonimoType>();
            }
            return this.antonimo;
        }

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
     *         &lt;element name="definicion" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "definicion"
    })
    public static class Definiciones {

        @XmlElement(required = true)
        protected List<String> definicion;

        /**
         * Gets the value of the definicion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the definicion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDefinicion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDefinicion() {
            if (definicion == null) {
                definicion = new ArrayList<String>();
            }
            return this.definicion;
        }

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
     *         &lt;element name="sinonimo" type="{}sinonimoType"/>
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
        "sinonimo"
    })
    public static class Sinonimos {

        @XmlElement(required = true)
        protected List<SinonimoType> sinonimo;

        /**
         * Gets the value of the sinonimo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sinonimo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSinonimo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SinonimoType }
         * 
         * 
         */
        public List<SinonimoType> getSinonimo() {
            if (sinonimo == null) {
                sinonimo = new ArrayList<SinonimoType>();
            }
            return this.sinonimo;
        }

    }

}
