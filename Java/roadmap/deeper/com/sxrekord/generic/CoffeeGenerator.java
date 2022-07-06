package com.sxrekord.generic;

import java.util.Iterator;
import java.util.Random;

/**
 * @author Rekord
 * @date 2022/6/30 16:37
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {
            Latte.class,
            Mocha.class
    };
    private static Random rand = new Random(47);

    public CoffeeGenerator() {}

    // For iterator

    private int size = 0;
    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[rand.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    };

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(2)) {
            System.out.println(c);
        }
    }
}
