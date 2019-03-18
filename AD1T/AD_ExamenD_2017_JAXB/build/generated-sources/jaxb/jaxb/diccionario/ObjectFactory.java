//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.17 a las 11:25:19 PM CET 
//


package jaxb.diccionario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.diccionario package. 
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

    private final static QName _Definicion_QNAME = new QName("", "definicion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.diccionario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DiccionarioEspanol }
     * 
     */
    public DiccionarioEspanol createDiccionarioEspanol() {
        return new DiccionarioEspanol();
    }

    /**
     * Create an instance of {@link PalabraType }
     * 
     */
    public PalabraType createPalabraType() {
        return new PalabraType();
    }

    /**
     * Create an instance of {@link DiccionarioEspanol.Palabras }
     * 
     */
    public DiccionarioEspanol.Palabras createDiccionarioEspanolPalabras() {
        return new DiccionarioEspanol.Palabras();
    }

    /**
     * Create an instance of {@link AntonimoType }
     * 
     */
    public AntonimoType createAntonimoType() {
        return new AntonimoType();
    }

    /**
     * Create an instance of {@link TraduccionType }
     * 
     */
    public TraduccionType createTraduccionType() {
        return new TraduccionType();
    }

    /**
     * Create an instance of {@link SinonimoType }
     * 
     */
    public SinonimoType createSinonimoType() {
        return new SinonimoType();
    }

    /**
     * Create an instance of {@link PalabraType.Definiciones }
     * 
     */
    public PalabraType.Definiciones createPalabraTypeDefiniciones() {
        return new PalabraType.Definiciones();
    }

    /**
     * Create an instance of {@link PalabraType.Sinonimos }
     * 
     */
    public PalabraType.Sinonimos createPalabraTypeSinonimos() {
        return new PalabraType.Sinonimos();
    }

    /**
     * Create an instance of {@link PalabraType.Antonimos }
     * 
     */
    public PalabraType.Antonimos createPalabraTypeAntonimos() {
        return new PalabraType.Antonimos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "definicion")
    public JAXBElement<Object> createDefinicion(Object value) {
        return new JAXBElement<Object>(_Definicion_QNAME, Object.class, null, value);
    }

}
