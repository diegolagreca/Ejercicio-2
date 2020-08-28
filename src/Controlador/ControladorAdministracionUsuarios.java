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

    public ResultSet obtenerUsuarios() throws SQLException {
        String sentencia = "SELECT * FROM usuarios;";
        // Ejecuto sentencia
        ResultSet setUsuarios = adminPostgres.enviarSentenciaSelect(sentencia);

        return setUsuarios;
    }

    public void eliminarUsuario(int id) throws SQLException {

        String sentencia = "DELETE FROM usuarios WHERE id_usuario =" + id + ";";
        adminPostgres.enviarSentencia(sentencia);
        obtenerUsuarios();
    }

    public boolean usuarioYaExiste(String unaId, String unUsuario) throws SQLException {
        try {
            // Ejecuto sentencia
            ResultSet usuarios = obtenerUsuarios();

            // Recorro el resultado de la sentencia 
            while (usuarios.next()) {

                String id_usuario = usuarios.getString("id_usuario");
                String usuario = usuarios.getString("usuario");
                if ((!id_usuario.equals(unaId)) && (usuario.equals(unUsuario))){
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;

    }

}
