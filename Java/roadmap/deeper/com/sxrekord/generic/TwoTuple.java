package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/6/30 12:18
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C three;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        three = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + three + ")";
    }
}

class TupleTest {
    public static void main(String[] args) {
        ThreeTuple<Integer, Double, String> threeTuple = new ThreeTuple<>(1, 10.0D, "abc");
        System.out.println(threeTuple);
    }
}
