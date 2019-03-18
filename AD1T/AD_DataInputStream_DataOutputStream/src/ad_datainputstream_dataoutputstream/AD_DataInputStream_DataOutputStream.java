/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author PCCOM
 */
public class AD_DataInputStream_DataOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Como escribir es un fichero con DataOutputStream, usaremos el método
         * write y el tipo de dato que queremos escribir:
         */
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\pruebasAD\\fich_binario.ddr"));) {

            //Escribimos un numero
            dos.writeInt(23);

            //Escribimos una cadena
            dos.writeUTF("Fernando");

            //Escribimos un numero
            dos.writeInt(1990);

        } catch (IOException e) {
            System.out.println("Error E/S");
        }

        /**
         * Ahora vamos a leer el fichero con un DataInputStream, usando el
         * método read y el tipo de dato a leer, es importante que leamos como
         * escribimos.
         */
        try (DataInputStream dis = new DataInputStream(new FileInputStream("C:\\pruebasAD\\fich_binario.ddr"));) {

            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());

            //Leemos una cadena y lo mostramos
            String nombre = dis.readUTF();
            System.out.println(nombre);
            if (nombre.equals("Fernando")) {
                System.out.println("Encontrado!");
            }

            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());

        } catch (IOException e) {
            System.out.println("Error E/S");
        }

    }

}
