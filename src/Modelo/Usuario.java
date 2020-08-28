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

    private String id;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private String documento;
    private String direccion;
    private String telefono;
    private LinkedList<Rol> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public Usuario(String nombre, String contraseña, String documento) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.documento = documento;
    }

    public Usuario(String id, String usuario, String contraseña, String nombre, String apellido, String documento, String direccion, String telefono) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void añadirRol(Rol rol) {
        getRoles().add(rol);
    }

}
