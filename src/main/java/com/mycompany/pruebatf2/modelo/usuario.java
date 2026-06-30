package com.mycompany.pruebatf2.modelo;

import java.sql.Timestamp;

/**
 * Clase modelo que representa la entidad "usuario".
 * Se han ajustado los métodos getter/setter para coincidir con 
 * los nombres utilizados en los archivos JSP.
 */
public class usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String clave;
    private String correo;
    private Timestamp fechaRegistro;

    public usuario() {
    }

    // Constructor completo
    public usuario(int idUsuario, String nombreUsuario, String clave, String correo, Timestamp fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    // Constructor simplificado
    public usuario(String nombreUsuario, String clave, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.correo = correo;
    }

    // --- MÉTODOS GETTERS Y SETTERS ACTUALIZADOS ---

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}