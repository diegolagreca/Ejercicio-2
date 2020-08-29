/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class ControladorAdministracionUsuarios {

    ControladorBD adminPostgres = new ControladorBD();

    /**
     * Obtiene todos los usuarios de la base de datos.
     *
     * @return @throws SQLException
     */
    public ResultSet obtenerUsuarios() throws SQLException {
        String sentencia = "SELECT * FROM usuarios;";
        // Ejecuto sentencia
        ResultSet setUsuarios = adminPostgres.enviarSentenciaSelect(sentencia);

        return setUsuarios;
    }

    /**
     * Mando sentencia DELETE a la base de datos para eliminar un usuario según
     * su Id.
     *
     * @param id
     * @throws SQLException
     */
    public void eliminarUsuario(int id) throws SQLException {

        String sentencia = "DELETE FROM usuarios WHERE id_usuario =" + id + ";";
        adminPostgres.enviarSentencia(sentencia);
        obtenerUsuarios();
    }

    /**
     * Evalúa si el usuario que voy a dar de alta ya exite Si la ID es la misma,
     * está bien que el nombre de usuario sea el mismo porque ahí efectivamente
     * es el mismo usuario. Pero yo no le puedo poner el mismo nombre de usuario
     * a usuarios con diferente Id.
     *
     * @param unaId
     * @param unUsuario
     * @return
     * @throws SQLException
     */
    public boolean usuarioYaExiste(int unaId, String unUsuario) throws SQLException {
        try {
            // Ejecuto sentencia
            ResultSet usuarios = obtenerUsuarios();

            // Recorro el resultado de la sentencia 
            while (usuarios.next()) {

                int id_usuario = Integer.valueOf(usuarios.getString("id_usuario"));
                String usuario = usuarios.getString("usuario");
                if ((id_usuario != unaId) && (usuario.equals(unUsuario))) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;

    }

    /**
     * Funcion que verifica que lo que estoy pasando es un número. La idea es
     * evaluar que los atributos "documento" y "direccion" del usuario sean
     * números antes de darlos de alta en la base de datos.
     *
     * @param input
     * @return
     */
    public boolean esNumero(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
