package com.sxrekord.map.hashtable;

import java.util.Hashtable;

/**
 * @author Rekord
 * @date 2022/7/11 20:36
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();

        table.put("John", 12);
        try {
            table.put(null, 12);
        } catch (Exception e) {
            System.out.println("the key is null");
        }
        try {
            table.put(12, null);
        } catch (Exception e) {
            System.out.println("the value is null");
        }

        table.put("KangKang", 17);

    }
}
