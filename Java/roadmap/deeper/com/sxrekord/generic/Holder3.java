package com.sxrekord.generic;
// practice 1
/**
 * @author Rekord
 * @date 2022/6/30 12:11
 */

public class Holder3<T> {
    private T a;
    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }


    public static void main(String[] args) {
        Holder3<Pet> holder3 = new Holder3<>(new Dog());

        // 编译不通过
//        Dog dog = holder3.get();
        Pet dog = holder3.get();

        // 编译不通过
//        holder3.set("Not a Dog");

    }
}
