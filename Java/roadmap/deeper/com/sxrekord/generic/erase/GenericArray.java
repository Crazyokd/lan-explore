package com.sxrekord.generic.erase;

/**
 * @author Rekord
 * @date 2022/7/1 10:07
 */
public class GenericArray<T> {
    private T[] array;
    private T val;
    public GenericArray(T val, int sz) {
        this.val = val;
        array = (T[])new Employee[sz];
        System.out.println("array.getClass().getSimpleName: " + array.getClass().getSimpleName());
        System.out.println("val: " + this.val.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10, 10);
    }
}

class Test {

}

// output
// Object[]