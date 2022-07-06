package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/7/5 9:30
 */
public class StaticGeneric<T> {
    // 报错：无法从 static 上下文引用 'com.sxrekord.generic.StaticGeneric.this'
//    public static void staticPrint(T t) {
//        System.out.println("I am in staticPrint");
//        System.out.println(t);
//    }

    public void print(T t) {
        System.out.println("I am in print");
        System.out.println(t);
    }

    public <E> void genericPrint(E e) {
        System.out.println("I am in genericPrint");
        System.out.println(e);
    }

    public static <E> void genericStaticPrint(E e) {
        System.out.println("I am in genericPrint");
        System.out.println(e);
    }
}


class StaticGenericTest {
    public static void main(String[] args) {
        StaticGeneric<String> stringStaticGeneric = new StaticGeneric<>();
        stringStaticGeneric.print("abc");
        // 报错：类型不正确
//        stringStaticGeneric.print(123);

        // test genericPrint
        System.out.println("--------------------------------------");
        stringStaticGeneric.genericPrint("abc");
        stringStaticGeneric.genericPrint(123);

        // test genericStaticPrint
        System.out.println("-------------------------------------");
        StaticGeneric.genericStaticPrint("abc");
        StaticGeneric.genericStaticPrint(123);
        // compile error
//        StaticGeneric<Integer>.genericStaticPrint("abc");
//        StaticGeneric<Integer>.genericStaticPrint(123);
    }
}
/** output
 * I am in print
 * abc
 * --------------------------------------
 * I am in genericPrint
 * abc
 * I am in genericPrint
 * 123
 * -------------------------------------
 * I am in genericPrint
 * abc
 * I am in genericPrint
 * 123
 */
