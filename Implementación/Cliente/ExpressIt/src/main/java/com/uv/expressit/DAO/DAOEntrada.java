/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.DAO;

import static com.uv.expressit.JSONUtils.JsonUtils.parsearJson;
import com.uv.expressit.POJO.Entrada;
import com.uv.expressit.POJO.Hashtag;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josuecg
 */
public class DAOEntrada {
    public static ArrayList<Entrada> obtenerEntradasSeguidor(long idUsuario, long idEntrada) throws MalformedURLException, IOException{
        ArrayList<Entrada> entradasSeguidos = new ArrayList<Entrada>();
        
        URL urlService = new URL("http://localhost:4000/feed/entradas_seguidores/"+idUsuario+"/"+idEntrada);
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
            entradaObtenida.setFechaEntrada((String) json.getString("ent_fechaEntrada"));
            entradaObtenida.setLikesEntrada((int) json.get("likes_totales"));
            
            try{
                if(json.get("tuLike")!=null){
                    entradaObtenida.setUsuarioLike(true);
                }   
            }catch(Exception ex){
                entradaObtenida.setUsuarioLike(false);
            }
            entradasSeguidos.add(entradaObtenida);
        }
        in.close();
        return entradasSeguidos;
    }
    
    public static Hashtag obtenerHashtag(String nombreHashtag){
        Hashtag hashtag = null;
        try{
            String jsonEnviar = String.format(
                    "{\"htg_nombre\": \"%s\"}", nombreHashtag
            );
            
            URL url = new URL("http://localhost:4000/feed/hashtag/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            
            OutputStream os = conn.getOutputStream(); 
            os.write(jsonEnviar.getBytes("UTF-8"));
            
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String hashtagRecibido = IOUtils.toString(in, "UTF-8");
            
            JSONObject jsonObtenido = new JSONObject(parsearJson(hashtagRecibido));
            hashtag = new Hashtag();
            hashtag.setIdHashtag((Long)jsonObtenido.get("htg_idHashtag"));
            hashtag.setTextoHashtag((String) jsonObtenido.get("htg_nombre"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return hashtag;
    }
    
    public static ArrayList<Entrada> obtenerEntradasUsuario(long idUsuario, String nombreUsuario) throws IOException{
         ArrayList<Entrada> entradasSeguidos = new ArrayList<Entrada>();
        
         
        URL urlService = new URL("http://localhost:4000/feed/entradas/"+nombreUsuario+"/"+idUsuario);
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
    
    public static int likearEntrada(long idEntrada, long idUsuario){
        int liked = 0;
        try{
            URL urlService = new URL("http://localhost:4000/feed/likear_entrada");
            String jsonEnviar = String.format(
                    "{\"lk_idEntrada\": \"%s\","
                            + "\"lk_idUsuario\": \"%s\"}", idEntrada, idUsuario
            );
            
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            
            OutputStream os = conn.getOutputStream(); 
            os.write(jsonEnviar.getBytes("UTF-8"));
            
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String mensaje = IOUtils.toString(in, "UTF-8");
            
            System.out.println(mensaje);
            in.close();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liked;
    }
    
    public static void borrarlikeEntrada(long idEntrada, long idUsuario){
        try{
            URL urlService = new URL("http://localhost:4000/feed/entrada_borrarlike/"+idEntrada+"/"+idUsuario);
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String mensaje = IOUtils.toString(in, "UTF-8");
            
            System.out.println(mensaje);
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean usuarioLike(long idEntrada, long idUsuario){
        boolean isLiked = false;
        try{
            URL urlService = new URL("http://localhost:4000/feed/entrada_likeusuario/"+idEntrada+"/"+idUsuario);
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String mensaje = IOUtils.toString(in, "UTF-8");
            if(mensaje.length() > 2){
                isLiked = true;
            }else{
                isLiked = false;
            }
            
            in.close();
        } catch (IOException ex) {
            isLiked = false;
        }
        return isLiked;
    }
    

}
