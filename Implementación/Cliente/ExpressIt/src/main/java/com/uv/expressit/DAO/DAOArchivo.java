/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.DAO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author josuecg
 */
public class DAOArchivo {
    public static BufferedImage obtenerFotoEntrada(long idEntrada) throws IOException{
        URL urlService = new URL("http://localhost:4000/files/media/"+1);
        HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        
        BufferedInputStream in = new BufferedInputStream(urlService.openStream());
        BufferedImage img = ImageIO.read(in);
        
        
        return img;
    }
    
    public static BufferedImage obtenerFotoPerfilUsuario(String nombreUsuario) throws MalformedURLException, IOException{
        BufferedImage img = null;
        URL urlService = new URL("http://localhost:4000/files/media/pictures/"+nombreUsuario);
        HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        BufferedInputStream in = new BufferedInputStream(urlService.openStream());
        img = ImageIO.read(in);
        return img;
    }
}
