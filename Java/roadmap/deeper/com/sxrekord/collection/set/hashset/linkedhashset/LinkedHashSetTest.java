package com.sxrekord.collection.set.hashset.linkedhashset;

import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * @author Rekord
 * @date 2022/7/9 18:23
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        linkedHashSet.add("Tom");
        linkedHashSet.add("John");
        linkedHashSet.add("Jane");
        linkedHashSet.add("Jack");
        linkedHashSet.add("Kangkang");

        for (Object o : linkedHashSet) {
            System.out.println(o);
        }
        int hashCode = new Object().hashCode();
        System.out.println(hashCode);
    }
}
