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
public class NoEsUnDirectorioNoSePuedeListar extends Exception {

    // Constructor
    public NoEsUnDirectorioNoSePuedeListar() {
    }

    // Excepción: Error provocado
    public String excErrorNoEsDir() {
        return "Error: No es un directorio, no se puede listar.";
    }

}
