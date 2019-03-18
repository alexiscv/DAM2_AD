/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_ej1_ficheros.logica;

/**
 * Clase que permite codificar un string con el Cifrado Cesar.
 *
 * @author Alexis Castaño
 */
public class Codificador {

    final String alfabeto = "abcdefghijklmnñopqrstuvwxyz";

    /**
     * Codifica un String con cifrado césar
     *
     * @param texto
     * @return
     */
    public String cifrar(String texto) {

        String cifrado = "";

        for (int i = 0; i < texto.length(); i++) {

            // Busco la letra "int i" en mi alfabeto
            // Para saber cual es y su posición en el mismo.
            int posicion = alfabeto.indexOf(texto.charAt(i));

            // Si la posición que ocupa es >= 0
            if (posicion >= 0) {
                // Añadimos la letra codificada posicion+3 el String.
                cifrado += alfabeto.charAt((posicion + 3) % alfabeto.length());

                // SE UTILIZA LA OPERACION MODULO PARA VOLVER AL INICIO DEL
                // ALFABETO CUANDO SE SALE POR EL FINAL
            } else {
                cifrado += texto.charAt(i);

            }
        }

        return cifrado;

    }

    public String descifrar(String texto) {

        String descifrado = "";

        for (int i = 0; i < texto.length(); i++) {

            // Busco la letra "int i" en mi alfabeto
            // Para saber cual es y su posición en el mismo.
            int posicion = alfabeto.indexOf(texto.charAt(i));

            // Si la posición que ocupa es >= 0
            if (posicion >= 0) {
                // Añadimos la letra codificada posicion-3 el String.
                descifrado += alfabeto.charAt((posicion - 3) % alfabeto.length());

                // SE UTILIZA LA OPERACION MODULO PARA VOLVER AL INICIO DEL
                // ALFABETO CUANDO SE SALE POR EL FINAL
            } else {
                descifrado += texto.charAt(i);

            }
        }

        return descifrado;

    }

}
