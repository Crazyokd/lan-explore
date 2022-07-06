package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/7/5 8:44
 */
public class Generic<T> {
}

class GenericTest {
    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>();
        Generic<Integer> integerGeneric = new Generic<>();

        System.out.println(stringGeneric.getClass());
        System.out.println(integerGeneric.getClass());

        System.out.println(stringGeneric.getClass() == integerGeneric.getClass());
    }
}
/** output
 * class com.sxrekord.generic.Generic
 * class com.sxrekord.generic.Generic
 * true
 */
