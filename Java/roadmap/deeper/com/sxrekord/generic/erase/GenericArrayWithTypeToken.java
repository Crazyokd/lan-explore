package com.sxrekord.generic.erase;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Rekord
 * @date 2022/7/1 9:43
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[])Array.newInstance(type, sz);
        System.out.println("array: " + array.getClass().getSimpleName());
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < array.length; i++) {
            res += get(i) + " ";
        }
        return res;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);

        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        Integer[] ia = gai.rep();
        System.out.println(gai);
        for (int i = 0; i < ia.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        test();
    }

    public static void test() {
        try {
            Object obj = Employee.class.getConstructor().newInstance();
            System.out.println(obj.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
