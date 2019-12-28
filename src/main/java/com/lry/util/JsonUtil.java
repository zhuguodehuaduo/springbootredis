package com.lry.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.util.List;

/**
 * @author liurenyi
 * @create 2019--12--28--15:44
 */
//json工具类
public class JsonUtil {
     //定义
    private static final ObjectMapper OM=new ObjectMapper();

    //对象转json字符串
    public static String objectToJson(Object data){
        try {
            OM.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //json转object
    public static Object jsonToObject(String json,Class type){
        try {
            Object object = OM.readValue(json, type);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //json转集合
    public static Object jsonTolist(String json,Class type){
        JavaType javaType=OM.getTypeFactory().constructParametricType(List.class,type);
        try {
            Object object = OM.readValue(json, type);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
