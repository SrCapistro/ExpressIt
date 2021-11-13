/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.POJO;

/**
 *
 * @author josuecg
 */
public class Usuario {
    private long idUsuario;
    private String nombreUsuario;
    private String descripcionUsuario;
    private String estatusUsuario;
    private String nombreCompletoUsuario;
    private String correoUsuario;
    private String tipoUsuario;
    private String contraseñaUsuario;
    private String fechaNacUsuario;
    private int cantidadEntradas;
    private int totalSeguidores;
    
    public Usuario() {
    }

    
    
    public Usuario(long idUsuario, String nombreUsuario, String descripcionUsuario, String estatusUsuario, String nombreCompletoUsuario, String correoUsuario, String tipoUsuario, String contraseñaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.descripcionUsuario = descripcionUsuario;
        this.estatusUsuario = estatusUsuario;
        this.nombreCompletoUsuario = nombreCompletoUsuario;
        this.correoUsuario = correoUsuario;
        this.tipoUsuario = tipoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDescripcionUsuario() {
        return descripcionUsuario;
    }

    public void setDescripcionUsuario(String descripcionUsuario) {
        this.descripcionUsuario = descripcionUsuario;
    }

    public String getEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(String estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }

    public String getNombreCompletoUsuario() {
        return nombreCompletoUsuario;
    }

    public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
        this.nombreCompletoUsuario = nombreCompletoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public String getFechaNacUsuario() {
        return fechaNacUsuario;
    }
    
    public void setFechaNacUsuario(String fechaNacUsuario) {
        this.fechaNacUsuario = fechaNacUsuario;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public int getTotalSeguidores() {
        return totalSeguidores;
    }

    public void setTotalSeguidores(int totalSeguidores) {
        this.totalSeguidores = totalSeguidores;
    }
}
