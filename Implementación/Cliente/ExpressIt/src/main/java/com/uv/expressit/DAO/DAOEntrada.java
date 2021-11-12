/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.DAO;

import static com.uv.expressit.JSONUtils.JsonUtils.parsearJson;
import com.uv.expressit.POJO.Entrada;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josuecg
 */
public class DAOEntrada {
    public static ArrayList<Entrada> obtenerEntradasSeguidor(long idUsuario) throws MalformedURLException, IOException{
        ArrayList<Entrada> entradasSeguidos = new ArrayList<Entrada>();
        
        URL urlService = new URL("http://localhost:4000/feed/entradas_seguidores/"+idUsuario);
        HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String entradaRecibida = IOUtils.toString(in, "UTF-8");
        JSONArray array = new JSONArray(entradaRecibida);
        
        for(int i=0; i<array.length();i++){
            JSONObject json = array.getJSONObject(i);
            Entrada entradaObtenida = new Entrada();
            entradaObtenida.setIdEntrada((int) json.get("ent_idEntrada"));
            entradaObtenida.setFechaEntrada((String) json.getString("ent_fechaEntrada"));
            entradaObtenida.setTextoEntrada((String) json.get("ent_textEntrada"));
            entradaObtenida.setNombreUsuario((String) json.getString("usr_nombreUsuario"));
            entradasSeguidos.add(entradaObtenida);
        }
        in.close();
        return entradasSeguidos;
    }
    
    public static int obtenerLikesEntrada(long idEntrada) throws MalformedURLException, IOException{
        int likesEntrada = 0;
        URL urlService = new URL("http://localhost:4000/feed/entrada_likes/"+idEntrada);
        HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String entradaRecibida = IOUtils.toString(in, "UTF-8");
        JSONObject json = new JSONObject(parsearJson(entradaRecibida)); 
        
        likesEntrada = (int) json.getInt("likes");
        in.close();
        
        return likesEntrada;
    }
}
