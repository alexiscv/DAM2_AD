/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_escribirficheroaccesoaleatorio;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author PCCOM
 */
public class AD_EscribirFicheroAccesoAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        RandomAccessFile miRAFile;
        String s = "Cadena a escribir1\n";
        String s2 = "Cadena a escribir2\n";
        String s3 = "Paco\n";

        // Abrimos el fichero de acceso aleatorio
        miRAFile = new RandomAccessFile("C:\\pruebasAD\\aleatorio.bin", "rw");

        // Escribimos
        add(miRAFile, s);
        add(miRAFile, s2);
        add(miRAFile, s3);

        // Leer
        //mostrarFichero(miRAFile);
        
        // Buscar
        buscar(miRAFile, "Paco");

        // Cerramos el fichero
        miRAFile.close();

    }

    public static void add(RandomAccessFile f, String s) throws IOException {

        // Nos vamos al final del fichero
        f.seek(f.length());

        // Incorporamos la cadena al fichero
        f.writeUTF(s);

    }

    public static void mostrarFichero(RandomAccessFile fichero) throws IOException {
        String s;

        fichero.seek(0); //nos situamos al principio

        while (true) {
            s = fichero.readUTF();  //se lee  un texto del fichero
            System.out.println("->" + s);  //se muestra en pantalla
        }

    }

    public static void buscar(RandomAccessFile fichero, String palabra) throws IOException {

        String s;
        boolean seguir = true;

        fichero.seek(0); //nos situamos al principio

        while (seguir) {
            s = fichero.readUTF();  //se lee un texto del fichero
            System.out.println("->" + s);  //se muestra en pantalla

            // Comparamos
            if (palabra.equals(s)) {
                System.out.println("ENCONTRADO!");
                seguir = false;

            }
        }

    }
}
