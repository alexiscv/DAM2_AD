/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej1_ficheros.exceptions;

/**
 *
 * @author Alexis
 */
public class CarpetaVacia extends Exception {
    
    public CarpetaVacia(){
    }

    public String excErrorEmpty() {
        return "Error: El directorio está vacío.";
    }
    
}
