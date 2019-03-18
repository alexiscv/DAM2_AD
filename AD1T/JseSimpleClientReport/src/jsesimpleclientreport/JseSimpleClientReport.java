/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsesimpleclientreport;

import java.math.BigInteger;
import org.netbeans.j2ee.wsdl.creditreport.CreditReport;

/**
 *
 * @author Alexis
 */
public class JseSimpleClientReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CreditReport cr = new CreditReport();

        cr.setFirstName("Butros Butros");
        cr.setLastName("Gali");
        cr.setDob("1930/05/30");
        cr.setScore("900");
        cr.setSsn("123-45-6789");

        cr.setLatestAddress1("2500 Some Ave");
        cr.setLatestAddress2("Suite 5000");
        cr.setCity("Nueva York");
        cr.setState("Nueva York");
        cr.setCountry("USA");
        cr.setPostalCode("NY 12345-6789");

        cr.setCurrency("USD");
        cr.setLiability(BigInteger.valueOf(2000000));
        cr.setLiquidAssests(BigInteger.valueOf(3000000));
        cr.setImmovableAssests(BigInteger.valueOf(5000000));
        
        // Escribimos jaxbm y pulsamos TAB
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(cr.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(cr, System.out);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

    }

}
