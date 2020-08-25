/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Diego
 */
public class ControladorSesion {
    // Instancio la clase Consultador para invocar las funciones de 
    // sentencias SQL

    public boolean usuarioAutenticado = false;
    ControladorBD adminPostgres = new ControladorBD();

    public boolean iniciarSesion(String usuario, String contraseña) throws SQLException {

        // TO DO lógica de inicio de sesión
        // Conecto con la base de datos
        adminPostgres.conectar();
        String sentencia = "SELECT * FROM usuarios WHERE usuario ='" + usuario + "' AND contraseña='" + contraseña + "';";
        String sesion = adminPostgres.enviarSentenciaInicioSesion(sentencia);
        if (sesion != null) {
            usuarioAutenticado = true;
        }
        return usuarioAutenticado;
    }

    public LinkedList<String>  obtenerRolesUsuario(String usuario) throws SQLException {
        LinkedList<String>  roles = null;
        if (usuarioAutenticado) {
            String sentencia = "SELECT roles.nombre_rol, usuarios.usuario\n"
                    + "FROM roles, usuarios, usuario_tiene_rol\n"
                    + "WHERE usuario_tiene_rol.id_usuario = usuarios.id_usuario\n"
                    + "	AND usuario_tiene_rol.id_rol = roles.id_rol\n"
                    + "	AND usuarios.usuario = '" + usuario + "';";
            roles = adminPostgres.enviarSentenciaObtenerRoles(sentencia);
        }
        return roles;
    }

    public String labelRolesUsuario(LinkedList<String> roles) {
        String labelRoles = "";
        for (int i = 0; i < roles.size(); i++) {
            if (i < 1) {
                labelRoles = roles.get(0);
            } else {
                labelRoles = labelRoles + ", " + roles.get(i);
            }
        }
        return labelRoles;
    }

}
