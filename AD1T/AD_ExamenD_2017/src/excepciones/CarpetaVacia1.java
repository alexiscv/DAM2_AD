/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Alexis
 */
public class CarpetaVacia1 extends Exception {
    
    public CarpetaVacia1(){
    }

    public String excErrorEmpty() {
        return "Error: El directorio está vacío.";
    }
    
}
