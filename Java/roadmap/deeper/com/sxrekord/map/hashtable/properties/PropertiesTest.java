package com.sxrekord.map.hashtable.properties;

import java.util.Properties;

/**
 * @author Rekord
 * @date 2022/7/11 20:50
 */
public class PropertiesTest {
    public static void main(String[] args) {
        java.util.Properties properties = new Properties();

        properties.put("John", 18);
//        properties.put(null, 23);
//        properties.put(23, null);

        System.out.println(properties.get("John"));

        // 修改
        properties.put("John", 22);
    }
}
