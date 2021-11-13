/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.POJO;

import java.util.ArrayList;

/**
 *
 * @author josuecg
 */
public class Entrada {
    private long idEntrada;
    private String nombreUsuario;
    private String fechaEntrada;
    private String textoEntrada;
    private int likesEntrada;
    private boolean usuarioLike;
    private ArrayList<Hashtag> listaHashtags;

    public Entrada() {
    }

    public long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(long idEntrada) {
        this.idEntrada = idEntrada;
    }

    public boolean getUsuarioLike() {
        return usuarioLike;
    }

    public void setUsuarioLike(boolean usuarioLike) {
        this.usuarioLike = usuarioLike;
    }
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }    

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getTextoEntrada() {
        return textoEntrada;
    }

    public void setTextoEntrada(String textoEntrada) {
        this.textoEntrada = textoEntrada;
    }

    public int getLikesEntrada() {
        return likesEntrada;
    }

    public void setLikesEntrada(int likesEntrada) {
        this.likesEntrada = likesEntrada;
    }

    public ArrayList<Hashtag> getListaHashtags() {
        return listaHashtags;
    }

    public void setListaHashtags(ArrayList<Hashtag> listaHashtags) {
        this.listaHashtags = listaHashtags;
    }
    
    
}
