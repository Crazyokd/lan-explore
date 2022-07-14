package com.sxrekord.collection.set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Rekord
 * @date 2022/7/11 21:03
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        treeSet.add("tree");
        treeSet.add("set");
//        treeSet.add(new Object());

        TreeSet ts = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

        ts.add("tree");
        ts.add("set");
    }
}
