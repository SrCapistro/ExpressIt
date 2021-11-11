/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uv.expressit.JSONUtils;

/**
 *
 * @author josuecg
 */
public class JsonUtils {
    public static String parsearJson(String json){
        json = json.replace("[", "");
        json = json.replace("]", "");
        return json;
    }
}
