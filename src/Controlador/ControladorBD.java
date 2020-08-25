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

    public ResultSet enviarSentenciaSQL(String sentencia) throws SQLException {
        // Guardo sentencia en variable

        conectar();
        // Ejecuto sentencia
        ResultSet resultSet = stmt.executeQuery(sentencia);
        return resultSet;

    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
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

    /**
     * Método para crear una tabla personalizada Para mantener el programa
     * simple, solo le estoy permitiendo al usuario crear una tabla con una
     * clave primaria y un dato de caracteres variados
     *
     * @param nombreTabla Nombre de la tabla que se creará
     * @param idTabla Nombre de la columna que contendrá la clave primaria
     * @param datoTabla Nombre de la columna que contendrá los datos
     * @throws SQLException
     */
    public void crearTablaPersonalizada(String nombreTabla, String idTabla, String datoTabla) throws SQLException {
        String queryCreate = "DROP TABLE IF EXISTS " + nombreTabla + ";\n"
                + "\n"
                + "CREATE TABLE " + nombreTabla + " (\n"
                + "	" + idTabla + " SERIAL PRIMARY KEY,\n"
                + "	" + datoTabla + " VARCHAR(255) NOT NULL\n"
                + ");";
        stmt.executeUpdate(queryCreate);

    }

    /**
     * Método para insertar datos en una tabla
     *
     * @param nombreTabla Nombre de la tabla objetivo
     * @param nombreColumna Nombre de la columna del dato insertado
     * @param datoTabla Dato a insertar
     * @throws SQLException
     */
    public void insertarDatosTabla(String nombreTabla, String nombreColumna, String datoTabla) throws SQLException {
        String queryInsert = "INSERT INTO " + nombreTabla + " (" + nombreColumna + ") VALUES\n"
                + "	('" + datoTabla + "');";
        stmt.executeUpdate(queryInsert);

    }

    /**
     * Método que imprime en pantalla el contenido de una tabla de la forma:
     * columna clave primara , columna dato
     *
     * @param nombreTabla nombre de la tabla que voy a listar
     * @param idTabla nombre de la columna de clave primaria de la tabla
     * @param nombreColumna nombre de la columna de datos descriptivos de la
     * tabla
     * @throws SQLException
     */
    public void listarDatosTabla(String nombreTabla, String idTabla, String nombreColumna) throws SQLException {
        // Guardo sentencia en variable
        String querySelect = "SELECT * FROM  " + nombreTabla;

        try {
            // Ejecuto sentencia
            ResultSet rs = stmt.executeQuery(querySelect);

            // Recorro e imprimo el resultado de la sentencia 
            while (rs.next()) {

                int id = rs.getInt(idTabla);

                String columna = rs.getString(nombreColumna);

                System.out.printf("ID: %s , " + nombreColumna + ": %s", id, columna);
                System.out.println();

            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

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

    /**
     * De ser una busqueda exitosa, se mostrará una fila que corresponda a la
     * 'id filtro' ingresada
     *
     * @param nombreTabla nombre de la tabla que voy a listar
     * @param idTabla nombre de la columna de clave primaria de la tabla
     * @param nombreColumna nombre de la columna de datos descriptivos
     * @param idFiltro clave primaria que voy a buscar
     * @throws SQLException
     */
    public void filtrarTablaPorID(String nombreTabla, String idTabla, String nombreColumna, String idFiltro) throws SQLException {
        // Guardo sentencia en variable
        String querySelectFilterID = "SELECT * FROM " + nombreTabla + " WHERE " + idTabla + " = '" + idFiltro + "'";

        try {
            // Ejecuto sentencia
            ResultSet rs = stmt.executeQuery(querySelectFilterID);
            // Recorro e imprimo el resultado de la sentencia 
            while (rs.next()) {

                int id = rs.getInt(idTabla);

                String columna = rs.getString(nombreColumna);

                System.out.printf("ID: %s , " + nombreColumna + ": %s", id, columna);
                System.out.println();

            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * Método que listará el contenido de una tabla de la forma: columna clave
     * primara , columna dato De ser una busqueda exitosa, se mostrarán
     * únicamente las filas que correspondan al criterio de búsqueda ingresado
     * con 'datoFiltro'
     *
     * @param nombreTabla nombre de la tabla que voy a listar
     * @param idTabla nombre de la columna de clave primaria de la tabla
     * @param nombreColumna nombre de la columna de datos descriptivos
     * @param datoFiltro cadena de caractéres por la que voy a filtrar en mi
     * columna determinada
     * @throws SQLException
     */
    public void filtrarTablaPorDato(String nombreTabla, String idTabla, String nombreColumna, String datoFiltro) throws SQLException {
        // Guardo sentencia en variable
        String querySelectFilter = "SELECT * FROM " + nombreTabla + " WHERE " + nombreColumna + " LIKE '%" + datoFiltro + "%'";

        try {
            // Ejecuto sentencia
            ResultSet rs = stmt.executeQuery(querySelectFilter);
            // Recorro e imprimo el resultado de la sentencia 
            while (rs.next()) {

                int id = rs.getInt(idTabla);

                String columna = rs.getString(nombreColumna);

                System.out.printf("ID = %s , " + nombreColumna + " = %s", id, columna);
                System.out.println();

            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // *** Métodos para pruebas ***
    // Todos los métodos a continuación fueron utilizados únicamente
    // para realizar pruebas y aprender
    /**
     * Método específico para crear tabla Albumes
     *
     * Antes de ejecutar la sentencia, elimino la tabla si es que ya existía. De
     * esta forma evito errores y puedo ejecutar mis pruebas varias veces sin
     * preocuparme.
     *
     * @throws SQLException
     */
    public void crearTablaAlbumes() throws SQLException {
        String queryCreate = "DROP TABLE IF EXISTS albumes;\n"
                + "\n"
                + "CREATE TABLE albumes (\n"
                + "	albumid SERIAL PRIMARY KEY,\n"
                + "	nombre VARCHAR(255) NOT NULL,\n"
                + "	banda VARCHAR(255) NOT NULL\n"
                + ");";
        stmt.executeUpdate(queryCreate);

    }

    /**
     * Método que inserta álbumes en la tabla Album Estas entradas corresponden
     * al nombre de un álbum, y la banda que lo hizo
     *
     * @param nombre nombre del álbum
     * @param banda nombre de la banda
     * @throws SQLException
     */
    public void insertarAlbum(String nombre, String banda) throws SQLException {
        String queryInsert = "INSERT INTO albumes (nombre, banda) VALUES\n"
                + "	('" + nombre + "','" + banda + "');";
        stmt.executeUpdate(queryInsert);

    }

    /**
     * Método que carga una serie de datos de prueba en la tabla Albumes
     *
     * @throws SQLException
     */
    public void insertarAlbumesPrueba() throws SQLException {
        String queryInsert = "INSERT INTO albumes (nombre, banda) VALUES\n"
                + "	('In Utero','Nirvana'),\n"
                + "	('The Wall','Pink Floyd'),\n"
                + "	('Burn','Deep Purple'),\n"
                + "	('OK Computer','Radiohead'),\n"
                + "	('Toxicity','System of a Down'),\n"
                + "	('Cowboys from Hell','Pantera'),\n"
                + "	('Heaven and Hell','Black Sabbath');";
        stmt.executeUpdate(queryInsert);

    }

    /**
     * Método que imprime en pantalla todo el contenido de la tabla Albumes
     *
     * @throws SQLException
     */
    public void listarAlbumes() throws SQLException {
        String querySelect = "SELECT * FROM albumes";
        ResultSet rs = stmt.executeQuery(querySelect);

        while (rs.next()) {

            int albumid = rs.getInt("AlbumId");

            String nombre = rs.getString("Nombre");

            String banda = rs.getString("Banda");

            System.out.printf("ID: %s , Nombre: %s, Banda: %s ", albumid, nombre, banda);
            System.out.println();

        }

    }

    /**
     * Metodo que busca una serie de entradas que cumplan un criterio
     * determinado en la tabla Albumes. De ser una búsqueda fructífera,
     * imprimirá por pantalla los resultados
     *
     * @param filtro
     * @throws SQLException
     */
    public void filtrarAlbumes(String filtro) throws SQLException {
        String querySelectFilter = "SELECT * FROM albumes WHERE banda LIKE '%" + filtro + "%'";
        ResultSet rs = stmt.executeQuery(querySelectFilter);

        while (rs.next()) {

            int albumid = rs.getInt("AlbumId");

            String nombre = rs.getString("Nombre");

            String banda = rs.getString("Banda");

            System.out.printf("ID: %s , Nombre: %s, Banda: %s ", albumid, nombre, banda);
            System.out.println();

        }
    }

    /**
     * Metodo que busca una entrada por clave primaria en la tabla Albumes. De
     * ser una búsqueda fructífera, imprimirá por pantalla el resultado
     *
     * @param id
     * @throws SQLException
     */
    public void buscarAlbumPorID(int id) throws SQLException {
        String querySelectFilterID = "SELECT * FROM albumes WHERE albumid = '" + id + "'";
        ResultSet rs = stmt.executeQuery(querySelectFilterID);

        while (rs.next()) {

            int albumid = rs.getInt("AlbumID");

            String nombre = rs.getString("Nombre");

            String banda = rs.getString("Banda");

            System.out.printf("ID: %s , Nombre: %s, Banda: %s ", albumid, nombre, banda);
            System.out.println();

        }
    }

    /**
     * Método que ejecutará una serie de sentencias de forma ordenada. Utilizo
     * este método para probar las distintas consultas SQL que se pedían
     * implementar en el programa. De forma ordenada, lo que hace este método es
     * 1) Establece la conexión con la base de datos 2) Crea la tabla Albumes 3)
     * Inserta una serie de entradas en la tabla Albumes 4) Inserta dos entradas
     * específicas en la tabla Albumes 5) Lista el contenido de la tabla Albumes
     * 6) Filtra los albumes por banda, desplegando en pantalla aquellos que
     * fueron lanzados por bandas cuyo nombre contenga "head" 7) Imprime por
     * pantalla el album con clave primaria (id) 2
     *
     * @throws SQLException
     */
    public void ejecutarPruebas() throws SQLException {
        // Me conecto a postgresql
        conectar();
        // Creo tabla Albumes
        crearTablaAlbumes();
        // Inserto datos de prueba
        insertarAlbumesPrueba();
        // Inserto dos entradas de prueba
        insertarAlbum("Another Perfect Day", "Motorhead");
        insertarAlbum("A Wonderful Life", "Mushroomhead");
        // Imprimo contenido de Albumes
        listarAlbumes();
        System.out.println("Y ahora filtro el conjunto resultado por bandas que incluyan 'head' en el nombre");
        // Filtrando por 'head' me tiene que salir Radiohead, Mushroomhead y Motorhead
        filtrarAlbumes("head");
        // Busco el album de ID 2, me tiene que salir The Wall
        System.out.println("Busco album de ID = 2");
        buscarAlbumPorID(2);
    }

}
