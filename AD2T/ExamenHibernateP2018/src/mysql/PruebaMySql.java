/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

/**
 *
 * @author Alexis
 */
public class PruebaMySql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Cremos un Obj. movmientos
        TotalMovimientos movimientos = new TotalMovimientos("examenpresencial", "root", "1234");
        int totalMovimientosPorDniYDias = movimientos.totalMovimientosPorDniYDias("dni", 5);//dni, ultimos 5 dias
        System.out.println("Numero de movimientos => " + totalMovimientosPorDniYDias);
    }

}
