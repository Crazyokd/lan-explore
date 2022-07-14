package com.sxrekord.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rekord
 * @date 2022/7/7 16:02
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add("Hello " + i + ".");
        }

        traverse(list);
    }

    public static void traverse(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
        System.out.println("=====================");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("======================");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=======================");
    }
}
