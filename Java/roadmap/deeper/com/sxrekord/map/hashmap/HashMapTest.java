package com.sxrekord.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Rekord
 * @date 2022/7/9 18:47
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("No1", "John");
        map.put("No2", "KangKang");
        map.put("No3", "Jack");
        // key 相同，替换值
        map.put("No2", "Alice");
        // 可以往map中加入null
        map.put(null, null);
        map.put("No4", null);
        map.put(null, "NULL");

        // key 并没有类型限制
        map.put(new Object(), new Object());
        map.remove(null);

        System.out.println(map.get(null));
        System.out.println("map=" + map);
        map.clear();

        Set entrySet = map.entrySet();

        double x = 2;
        System.out.println(String.format("%.5f", x));
    }
}
