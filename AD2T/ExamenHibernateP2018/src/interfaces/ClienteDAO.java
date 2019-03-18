/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Alexis
 */
public interface ClienteDAO {

    public boolean traspaso(String cuentaOrigen, String cuentaDestino, float cantidad);

    public boolean tranferencia(String cuentaOrigen, String cuentaDestino, float cantidad);

    public boolean crearCuenta();

}
