package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/7/5 9:50
 */public class Box<T> {
    private T val;
    public Box(T t) {
        val = t;
    }

    public T get() {
        return val;
    }
}

class BoxTest {
    public static void main(String[] args) {
        Box<Number> box = new Box<>(100);
        showBox(box);

        Box<Integer> integerBox = new Box<>(200);
        // compile error
//        showBox(integerBox);
        showBox(integerBox);

        Box<?> bbox = new Box<Double>(120.123);
        Object obj = bbox.get();
        System.out.println(obj);
    }

//    public static void showBox(Box<Number> box) {
//        Number number = box.get();
//        System.out.println(number);
//    }

    public static void showBox(Box<?> box) {
        // compile error
//        Integer integer = box.get();
//        Number number = box.get();

        Object object = box.get();
        System.out.println(object);
    }

    // compile error：方法冲突
//    public static void showBox(Box<Integer> box) {
//        Integer integer = box.get();
//        System.out.println(integer);
//    }
}

/**
 * 1. 泛型类型的具体类型之间无法重载：如 Box<Integer> 与 Box<Number> 被视为同一种类型
 * 2. 泛型类型的具体类型存续的继承关系不再有效，如 Box<Number> box = new Box<Integer>(); // compile error
 * 3. 由于第二点存在的问题，故引出通配符 ? 。 Box<?> box = new Box<Number>; // compile success
 * 4. 同时由于使用了通配符，得到的类型也将回到原点，成为 Object
 */