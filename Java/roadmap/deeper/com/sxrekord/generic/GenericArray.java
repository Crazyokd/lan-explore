package com.sxrekord.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Rekord
 * @date 2022/7/5 20:30
 */
public class GenericArray {
    public static void main(String[] args) {
        // compile error
//        ArrayList<String>[] arrayLists = new ArrayList<String>[5];
        ArrayList<String>[] arrayLists = new ArrayList[5];

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        // compile error
//        arrayLists[0] = integers;
        arrayLists[0] = strings;
    }
}
