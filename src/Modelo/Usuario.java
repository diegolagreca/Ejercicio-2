/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;

/**
 *
 * @author Diego
 */
public class Usuario {

    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private int documento;
    private String direccion;
    private int telefono;
    private LinkedList<Rol> roles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LinkedList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(LinkedList<Rol> roles) {
        this.roles = roles;
    }

    public Usuario(String nombre, String contraseña, int documento) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.documento = documento;
    }
    
    public void añadirRol(Rol rol){
        getRoles().add(rol);        
    }

}
