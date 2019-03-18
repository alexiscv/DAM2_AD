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
public class DirectorioYaExiste extends Exception {

    String directorio;

    // Constructor
    public DirectorioYaExiste() {
    }

    public DirectorioYaExiste(String directorio) {
        this.directorio = directorio;
    }

    // Excepción: Error provocado
    public String exErrorDirYaExiste() {
        return "Error: El directorio (" + this.directorio + ") ya existe.";
    }

}
