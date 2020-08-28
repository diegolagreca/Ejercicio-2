/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase maneja la conexión con la base de datos y los métodos que,
 * mediante sentencias SQL, se encargarán de consultar la base de datos; se
 * utilizan sentencias SELECT, INSERT y CREATE TABLE
 *
 * @author Diego Vázquez
 */
public class ControladorBD {

    // Variables para conexión con la base de datos
    private final String HOSTNAME = "192.168.56.102";
    private final int PUERTO = 5432;
    private final String BASE_DE_DATOS = "pruebadb2";
    private final String USUARIO = "postgres";
    private final String PASSWORD = "pwdpostgres";

    // Inicializo statement para realizar consultas SQL
    private Statement stmt = null;

    /**
     * Método para conectarse a la base de datos
     *
     * @throws SQLException
     */
    public void conectar() throws SQLException {

        // Se establece conexión con postgresql
        try {
            Connection conn = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", HOSTNAME, PUERTO, BASE_DE_DATOS), USUARIO, PASSWORD);

            Class.forName("org.postgresql.Driver");
            //System.out.println("Conexión establecida con " + HOSTNAME + ".");

            stmt = conn.createStatement();

        } catch (ClassNotFoundException | SQLException e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public ResultSet enviarSentenciaSelect(String sentencia) throws SQLException {
        // Guardo sentencia en variable

        conectar();
        // Ejecuto sentencia
        ResultSet resultSet = stmt.executeQuery(sentencia);
        return resultSet;

    }

    public static DefaultTableModel construirModeloTabla(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

    public void enviarSentencia(String sentencia) throws SQLException {
        conectar();
        stmt.executeUpdate(sentencia);
    }

    public String enviarSentenciaInicioSesion(String sentencia) throws SQLException {
        try {
            // Ejecuto sentencia
            ResultSet rs = stmt.executeQuery(sentencia);

            // Recorro el resultado de la sentencia 
            while (rs.next()) {

                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                System.out.printf("usuario: %s , " + "contraseña" + ": %s", usuario, contraseña);
                return usuario;
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public LinkedList<String> enviarSentenciaObtenerRoles(String sentencia) throws SQLException {
        LinkedList<String> listaRoles = new LinkedList<>();
        try {
            // Ejecuto sentencia
            ResultSet rs = stmt.executeQuery(sentencia);

            // Recorro el resultado de la sentencia 
            while (rs.next()) {
                String nombreRol = rs.getString("nombre_rol");
                listaRoles.add(nombreRol);
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return listaRoles;
    }

}
