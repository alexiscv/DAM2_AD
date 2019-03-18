/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej1_ficheros.logica;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Alexis Castaño
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
     * Filtra Imágenes
     */
    public static class FiltroImagenes implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {

            String[] extensionesImagenes = {"jpg", "bmp", "tif"}; // etc...

            for (String extensionImagenes : extensionesImagenes) {
                if (name.endsWith(extensionImagenes)) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Retorna un listado de solo directorios.
     */
    public static class FiltroSoloDirectorios implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            File ficheroLeido = new File(dir.getAbsolutePath() + File.separator + name);
            //System.out.println(">> " + dir.getAbsolutePath() + File.separator + name + " | es:" + ficheroLeido.isDirectory());
            return ficheroLeido.isDirectory();
            
        }

    }

}
