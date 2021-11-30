/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.DAO;

import static com.uv.expressit.JSONUtils.JsonUtils.parsearJson;
import com.uv.expressit.POJO.Usuario;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 *
 * @author josuecg
 */
public class DAOUsuario {
    
    
   
    public static Usuario ObtenerLogin(String usuario, String contraseña) throws IOException{
        Usuario usuarioObtenido = null;
        
        //AQUÍ CREAMOS LA CADENA JSON QUE MANDAREMOS Y LE DAMOS EL FORMATO
        //QUE SE USA EN JSON, INSERTAMOS LAS CREDENCIALES CON UN STRING.FORMAT
        /*String credencialesJson = String.format(
                "{\"nombreUsuario\": \"%s\", "
                + "\"contraseña\": \"%s\""
                        + "}", usuario, contraseña);*/
        
        URL urlService = new URL("http://localhost:4000/auth/login/"+usuario+"/"+contraseña); //INGRESAMOS LA DIRECCIÓN QUE VAMOS A OCUPAR PARA EL LOGIN
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection(); //CREAMOS LA CONEXIÓN DE TIPO HTTTPURLCONNECTION Y SAMOS EL URL QUE CREAMOS
            
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); //ESTA LINEA ES PARA HACERLE SABER QUE MANDAREMOS UN ELEMENTO DE TIPO JSON AL BODY 
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); //ESPECIFICAMOS EL TIPO DE METODO QUE USAREMOS, DEBE DE SER EL MISMO QUE EL DE LA API

            //OutputStream os = conn.getOutputStream(); //CREAMOS UN STREAM DE SALIDA
            //os.write(credencialesJson.getBytes("UTF-8")); //ESCRIBIMOS Y MANDAMOS LOS BYTES DEL JSON CREADO
            
            InputStream in = new BufferedInputStream(conn.getInputStream());  //CREAMOS UN INPUTSTREAM PARA LA ENTRADA DEL REQUEST
            String usuarioRecibido = IOUtils.toString(in, "UTF-8"); //RECIBIMOS LA RESPUESTA
            
            JSONObject jsonObtenido = new JSONObject(parsearJson(usuarioRecibido)); //EN ESTE CASO LA RESPUESTA ES UN JSON POR LO TANTO CREAMOS UN JSON OBJSECT
            
            //PASAMOS LOS DATOS DEL JSON A EL USUARIO O EL OBJETO EN CUESTIÓN
            usuarioObtenido = new Usuario();
            usuarioObtenido.setIdUsuario((Integer) jsonObtenido.get("usr_idUsuario"));
            usuarioObtenido.setNombreUsuario(jsonObtenido.getString("usr_nombreUsuario"));
            usuarioObtenido.setDescripcionUsuario((String) jsonObtenido.get("usr_descripcion").toString());
            usuarioObtenido.setNombreCompletoUsuario(jsonObtenido.getString("usr_nombre"));
            usuarioObtenido.setCorreoUsuario(jsonObtenido.getString("usr_correo"));
            usuarioObtenido.setTipoUsuario(jsonObtenido.getString("usr_tipoUsuario"));
            usuarioObtenido.setFechaNacUsuario((jsonObtenido.get("usr_fechaNacimiento").toString()));
            
            if(jsonObtenido.getInt("usr_estatus") == 1){
                usuarioObtenido.setEstatusUsuario("Activo");
            }else{
                usuarioObtenido.setEstatusUsuario("Inactivo");
            }
            in.close();
        
        return usuarioObtenido;
    }
    
    public static String registrarUsuario(Usuario usuario) throws IOException{
        String credencialesJson = String.format(
                "{\"usr_nombreUsuario\": \"%s\","
                        + "\"usr_contraseña\": \"%s\","
                        + "\"usr_nombre\": \"%s\","
                        + "\"usr_correo\": \"%s\","
                        + "\"usr_fechaNacimiento\": \"%s\","
                        + "\"usr_descripcion\": \"%s\","
                        + "\"usr_estatus\": 1,"
                        + "\"usr_tipoUsuario\": \"Comun\"}", usuario.getNombreUsuario(),
                        usuario.getContraseñaUsuario(), usuario.getNombreCompletoUsuario(),
                        usuario.getCorreoUsuario(), usuario.getFechaNacUsuario(), usuario.getDescripcionUsuario());
        
        URL urlService = new URL("http://localhost:4000/users/signup");
        HttpURLConnection conn = (HttpURLConnection) urlService.openConnection();
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        
        OutputStream os = conn.getOutputStream();
        os.write(credencialesJson.getBytes("UTF-8"));
        
        InputStream in = new BufferedInputStream(conn.getInputStream());  
        String mensaje = IOUtils.toString(in, "UTF-8");
        
        return mensaje;
    }
    
    public static Usuario obtenerUsuarioPorUsername(String nombreUsuario) throws IOException{
        Usuario usuarioObtenido = null;
        
        URL urlService = new URL("http://localhost:4000/users/"+nombreUsuario); 
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection(); 
            
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); 
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            
            InputStream in = new BufferedInputStream(conn.getInputStream());  
            String usuarioRecibido = IOUtils.toString(in, "UTF-8");
            JSONObject jsonObtenido = new JSONObject(parsearJson(usuarioRecibido)); 
            
            usuarioObtenido = new Usuario();
            usuarioObtenido.setIdUsuario((int) jsonObtenido.get("usr_idUsuario"));
            usuarioObtenido.setNombreUsuario(jsonObtenido.getString("usr_nombreUsuario"));
            usuarioObtenido.setDescripcionUsuario((String) jsonObtenido.get("usr_descripcion").toString());
            usuarioObtenido.setNombreCompletoUsuario(jsonObtenido.getString("usr_nombre"));
            usuarioObtenido.setCantidadEntradas((int) jsonObtenido.getInt("entradasTotales"));
            usuarioObtenido.setTotalSeguidores((int) jsonObtenido.get("seguidores"));
            usuarioObtenido.setFechaNacUsuario((jsonObtenido.get("usr_fechaNacimiento").toString()));
            
            in.close();
        
        return usuarioObtenido;
    }
    
  
}
