/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.DAO;

import static com.uv.expressit.JSONUtils.JsonUtils.parsearJson;
import com.uv.expressit.POJO.Usuario;
import java.io.BufferedInputStream;
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
    
    
   
    public static Usuario ObtenerLogin(String usuario, String contraseña){
        Usuario usuarioObtenido = null;
        
        //AQUÍ CREAMOS LA CADENA JSON QUE MANDAREMOS Y LE DAMOS EL FORMATO
        //QUE SE USA EN JSON, INSERTAMOS LAS CREDENCIALES CON UN STRING.FORMAT
        String credencialesJson = String.format(
                "{\"nombreUsuario\": \"%s\", "
                + "\"contraseña\": \"%s\""
                        + "}", usuario, contraseña);
        
        try{
            URL urlService = new URL("http://localhost:4000/auth/login"); //INGRESAMOS LA DIRECCIÓN QUE VAMOS A OCUPAR PARA EL LOGIN
            HttpURLConnection conn = (HttpURLConnection) urlService.openConnection(); //CREAMOS LA CONEXIÓN DE TIPO HTTTPURLCONNECTION Y SAMOS EL URL QUE CREAMOS
            
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); //ESTA LINEA ES PARA HACERLE SABER QUE MANDAREMOS UN ELEMENTO DE TIPO JSON AL BODY 
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); //ESPECIFICAMOS EL TIPO DE METODO QUE USAREMOS, DEBE DE SER EL MISMO QUE EL DE LA API

            OutputStream os = conn.getOutputStream(); //CREAMOS UN STREAM DE SALIDA
            os.write(credencialesJson.getBytes("UTF-8")); //ESCRIBIMOS Y MANDAMOS LOS BYTES DEL JSON CREADO
            
            InputStream in = new BufferedInputStream(conn.getInputStream());  //CREAMOS UN INPUTSTREAM PARA LA ENTRADA DEL REQUEST
            String usuarioRecibido = IOUtils.toString(in, "UTF-8"); //RECIBIMOS LA RESPUESTA
            
            JSONObject jsonObtenido = new JSONObject(parsearJson(usuarioRecibido)); //EN ESTE CASO LA RESPUESTA ES UN JSON POR LO TANTO CREAMOS UN JSON OBJSECT
            
            //PASAMOS LOS DATOS DEL JSON A EL USUARIO O EL OBJETO EN CUESTIÓN
            usuarioObtenido = new Usuario();
            usuarioObtenido.setIdUsuario(jsonObtenido.getInt("usr_idUsuario"));
            usuarioObtenido.setNombreUsuario(jsonObtenido.getString("usr_nombreUsuario"));
            usuarioObtenido.setDescripcionUsuario(jsonObtenido.get("usr_descripcion").toString());
            usuarioObtenido.setNombreCompletoUsuario(jsonObtenido.getString("usr_nombre"));
            usuarioObtenido.setCorreoUsuario(jsonObtenido.getString("usr_correo"));
            usuarioObtenido.setTipoUsuario(jsonObtenido.getString("usr_tipoUsuario"));
            usuarioObtenido.setFechaNacUsuario((jsonObtenido.get("usr_fechaNacimiento").toString()));
            
            if(jsonObtenido.getInt("usr_estatus") != 1){
                usuarioObtenido.setEstatusUsuario("Activo");
            }else{
                usuarioObtenido.setEstatusUsuario("Inactivo");
            }
            in.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usuarioObtenido;
    }
}
