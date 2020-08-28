/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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

}
