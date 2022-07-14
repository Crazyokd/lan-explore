package com.sxrekord.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rekord
 * @date 2022/7/7 16:23
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add("hello " + i + ".");
        }
    }
}
