/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Alexis
 */
public class Filtros {

    /**
     * Filtra un directorio por extensión
     */
    public static class FiltroExtension implements FilenameFilter {

        String extension;

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }

        public FiltroExtension(String extension) {
            this.extension = extension;
        }

    }

    /**
     * Filtra un directorio por una extensión y si el archivo empieza por vocal.
     */
    public static class FiltroExtensionEmpiezaVocal implements FilenameFilter {

        // Atributos
        String extension;

        @Override
        public boolean accept(File dir, String name) {

            if (name.endsWith(extension) && isVocal(name.charAt(0))) {
                return true;
            }

            return false;

        }

        /**
         * Constructor
         *
         * @param extension
         */
        public FiltroExtensionEmpiezaVocal(String extension) {
            this.extension = extension;
        }

        public boolean isVocal(Character caracter) {

            // Pasamos a mínusculas para evitar comparar mayusculas
            caracter = Character.toLowerCase(caracter);

            if (caracter.equals('a') || caracter.equals('e') || caracter.equals('i') || caracter.equals('o') || caracter.equals('u')) {
                return true;
            } else {
                return false;
            }
        }

    }

}
