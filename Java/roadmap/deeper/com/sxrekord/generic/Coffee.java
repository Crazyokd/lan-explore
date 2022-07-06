package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/6/30 16:35
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {}

class Mocha extends Coffee {}
