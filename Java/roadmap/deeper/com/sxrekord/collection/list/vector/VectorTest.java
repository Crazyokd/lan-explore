package com.sxrekord.collection.list.vector;

import java.util.Vector;

/**
 * @author Rekord
 * @date 2022/7/7 17:33
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();

        for (int i = 0; i < 10; i++) {
            vector.add("Hello " + i + ".");
        }
    }
}
