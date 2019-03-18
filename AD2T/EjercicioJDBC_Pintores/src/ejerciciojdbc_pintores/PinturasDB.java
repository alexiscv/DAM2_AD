/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdbc_pintores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexis
 */
public class PinturasDB {

    private Statement stmt;
    private Connection con;
    private PreparedStatement pstmt;

    /**
     * Constructor
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public PinturasDB() throws SQLException, ClassNotFoundException {
        this.conectarDB();
    }

    /**
     * Conectar a la DB
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void conectarDB() throws SQLException, ClassNotFoundException {
        // Conexión a la base de datos
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "pinturas";
        String cadenaConexion = "jdbc:mysql://localhost/" + db + "?user=root&password=1234&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.con = DriverManager.getConnection(cadenaConexion);
        this.stmt = con.createStatement();
    }

    /**
     * Muestra todos los pintores
     *
     * @throws SQLException
     */
    public void getAllPintores() throws SQLException {

        // Ejecutamos la consulta
        ResultSet rs = this.stmt.executeQuery("SELECT * FROM pintores");

        // Creamos una variable para los nombres
        String nombre;

        // Recorremos el ResultSet
        while (rs.next()) {
            nombre = rs.getString("nombre");    // Cargamos el nombre
            System.out.println(nombre);         // Lo mostramos por consola
        }
    }

    /**
     * Retorna los pintores de un determinado año
     *
     * @param anio
     * @throws SQLException
     */
    public void getPintoresFromYear(int anio) throws SQLException {

        // Ejecutamos la consulta
        ResultSet rs = this.stmt.executeQuery("SELECT * FROM pintores WHERE anio = " + anio);

        // Creamos una variable para los nombre
        String nombre;

        // Recorremos el ResultSet
        while (rs.next()) {
            nombre = rs.getString("nombre");    // Cargamos el nombre
            System.out.println(nombre);         // Lo mostramos por consola
        }
    }

    /**
     * Muestra todos los cuadros de un pintor usando PreparedStatement
     *
     * @param id_autor
     * @throws SQLException
     */
    public void getAllCuadrosOf(int id_autor) throws SQLException {

        // Preparamos la consulta
        this.pstmt = this.con.prepareStatement("SELECT * FROM cuadros WHERE id_autor = ?");

        // Pasamos los parametros a los "?"
        this.pstmt.setInt(1, id_autor);
        
        // Ejecutamos la consulta
        //this.pstmt.executeUpdate();
        
        // Ejecutamos la consulta
        ResultSet rs = pstmt.executeQuery();

        // Creamos una variable para los nombre
        String nombre;

        // Recorremos el ResultSet
        while (rs.next()) {
            nombre = rs.getString("titulo");    // Cargamos el nombre
            System.out.println(nombre);         // Lo mostramos por consola
        }

    }

    /**
     * Inserta un pintor de la base de datos
     *
     * @param nombre
     * @param anio_nacimiento
     * @param estilo
     * @throws SQLException
     */
    public void insertPintor(String nombre, int anio_nacimiento, String estilo) throws SQLException {

        this.stmt.executeUpdate("INSERT INTO `pinturas`.`pintores` (`nombre`, `anio`, `estilo`) VALUES ('" + nombre + "', '" + anio_nacimiento + "', '" + estilo + "');");
        System.out.println("--> Insertado: " + nombre);

    }

    /**
     * Elimina un pintor a partir de su nombre
     *
     * @param nombre
     * @throws SQLException
     */
    public void deletePintor(String nombre) throws SQLException {

        this.stmt.executeUpdate("DELETE FROM `pinturas`.`pintores` WHERE `nombre` = '" + nombre + "';");
        System.out.println("--> Eliminado: " + nombre);
    }

    /**
     * Elimina todos los pintores
     *
     * @throws SQLException
     */
    public void deleteAllPintores() throws SQLException {

        this.stmt.executeUpdate("DELETE FROM `pinturas`.`pintores` WHERE 1+1;");
        System.out.println("--> Eliminados todos los pintores: ");
    }

}
