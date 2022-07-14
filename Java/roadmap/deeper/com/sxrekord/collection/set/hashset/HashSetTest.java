package com.sxrekord.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rekord
 * @date 2022/7/7 18:26
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("Tom");
//        set.add("Jack", "cool");
        set.add("John");
        set.add("Alice");
        set.add("Tom");
        set.add(null);

        System.out.println(set.size());

        for (Object o : set) {
            System.out.println(o);
        }

    }
}
