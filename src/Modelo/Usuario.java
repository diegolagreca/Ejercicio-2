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

    private int id;
    private String usuario;
    private String contraseña;
    private String nombre;
    private String apellido;
    private int documento;
    private String direccion;
    private int telefono;
    private LinkedList<Rol> roles;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     *
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     *
     * @return
     */
    public int getDocumento() {
        return documento;
    }

    /**
     *
     * @param documento
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    public LinkedList<Rol> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(LinkedList<Rol> roles) {
        this.roles = roles;
    }

    /**
     *
     * @param nombre
     * @param contraseña
     * @param documento
     */
    public Usuario(String nombre, String contraseña, int documento) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.documento = documento;
    }

    /**
     *
     * @param id
     * @param usuario
     * @param contraseña
     * @param nombre
     * @param apellido
     * @param documento
     * @param direccion
     * @param telefono
     */
    public Usuario(int id, String usuario, String contraseña, String nombre, String apellido, int documento, String direccion, int telefono) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     *
     * @param rol
     */
    public void añadirRol(Rol rol) {
        getRoles().add(rol);
    }

}
