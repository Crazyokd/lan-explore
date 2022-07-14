package com.sxrekord.collection.list.linkedlist;

import java.util.LinkedList;

/**
 * @author Rekord
 * @date 2022/7/7 17:53
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10; i++) {
            linkedList.add("hello " + i + ".");
        }

        linkedList.remove();

        linkedList.remove(2);

    }
}
