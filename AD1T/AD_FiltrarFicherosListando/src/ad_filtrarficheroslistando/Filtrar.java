/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_filtrarficheroslistando;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Alexis
 */
public class Filtrar implements FilenameFilter {

    private String extension;

    /**
     * Constructor
     *
     * @param extension
     */
    public Filtrar(String extension) {
        this.extension = extension;
    }

    
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

}
