/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_jaxb_albaran;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import jaxb.albaran.PedidoType;
import logica.OperacionesAlbaran;

/**
 *
 * @author Alexis
 */
public class Main2 {

    public static void main(String[] args) {

        OperacionesAlbaran op = new OperacionesAlbaran();

        // Unmarshalizar un documento XML
        JAXBElement jaxbElement = op.unmarshalizar("src\\albaran.xml");

        // El método getValue() retorna el modelo de contenido (content model)
        // y el valor de los atributos del elemento
        PedidoType pedidoType = (PedidoType) jaxbElement.getValue();

        // Añadir un pedido
        op.addArticulo(pedidoType, 22, "ABC", "Silla de playa", 10, 2018, 8, 11);

        // Eliminar un articulo de un pedido
        op.borrarArticulo(pedidoType, "ABC");

        // Modificar una dirección
        op.modDireccion(pedidoType, "Paco Jones", "C/ Oscura", "Oviedo", "Galicia", new BigDecimal(33009));

        // Marshalizar Obj. en memoria a un XML
        op.marshalizar(jaxbElement);

        // Mostrar total del pedido
        op.importePedido(pedidoType);

    }

}
