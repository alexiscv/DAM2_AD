/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexis
 */
public class TotalMovimientos {

    private Connection connection = null;
    private Statement stmt = null;

    /**
     * Constructor
     *
     * @param database
     * @param user
     * @param pass
     */
    public TotalMovimientos(String database, String user, String pass) {
        connection = conexion(database, user, pass);
        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Metodo conexion Recibe el nombre de la base de datos y establece una
     * connetion
     *
     * @param database
     * @param user
     * @param pass
     * @return Connection
     */
    private Connection conexion(String database, String user, String pass) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String cadenaConexion = "jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + pass + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            con = DriverManager.getConnection(cadenaConexion);
            return con;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Clase no encontrada");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    /**
     * Metodo privado que me transforma los dias en un long dias*24*60*60*1000
     *
     * @param dias
     * @return long dias
     */
    private long diasToLong(int dias) {
        return dias * 24 * 60 * 60 * 1000;
    }

    /**
     * Metodo cuenta el total de movimientos que ha tenido un cliente en un
     * numero de dias
     *
     * @param dni
     * @param numeroDias
     * @return numero de dias, -1 caso negativo
     */
    public int totalMovimientosPorDniYDias(String dni, int numeroDias) {
        int totalmovimientos = 0;
        try {
            PreparedStatement movimientos = null;
            String query = "select m.* from movimiento as m, cuenta_movimiento as cm,"
                    + " cuenta as c, cliente as cl "
                    + "WHERE cl.dni = ? AND cl.id = c.cliente_id AND c.id = cm.Cuenta_id "
                    + "AND cm.movimientos_id = m.idMovimiento AND m.fecha >= ?";
            connection.setAutoCommit(false);
            movimientos = connection.prepareCall(query);
            movimientos.setString(1, dni);
            movimientos.setDate(2, new Date(diasToLong(numeroDias)));
            ResultSet executeQuery = movimientos.executeQuery();

            while (executeQuery.next()) {
                totalmovimientos++;
            }
            return totalmovimientos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}
