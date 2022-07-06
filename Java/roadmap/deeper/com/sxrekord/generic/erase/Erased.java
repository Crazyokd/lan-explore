package com.sxrekord.generic.erase;

import java.time.chrono.Era;

/**
 * @author Rekord
 * @date 2022/6/30 23:25
 */
public class Erased<T> {
    private final int SIZE = 10;
    T[] array;
    public void f(Object arg) {
//        T var = new T();
//        if (arg instanceof T) {}
//        T[] array = new T[SIZE];
        array = (T[])new Object[SIZE];
    }

    public void init(T t) {
        for (int i = 0; i < SIZE; i++) {
            array[i] = t;
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < SIZE; i++) {
            res += array[i] + " ";
        }
        return res;
    }
}

class Ed {
    int a = 1;
    int b = 2;

    @Override
    public String toString() {
        return a + ", " + b;
    }
}
class ErasedTest {
    public static void main(String[] args) {
        Erased<Ed> erased = new Erased<>();
        erased.f("hi");
        erased.init(new Ed());
        System.out.println(erased);
//        System.out.println(erased.array[1]);
    }
}



