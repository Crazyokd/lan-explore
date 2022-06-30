package com.sxrekord.oop;

/**
 * @author Rekord
 * @date 2022/6/20 16:36
 */

public class FinalTest {
    public static void main(String[] args) {
        TypeOne t1 = new TypeThree();
        t1.foo();
        TypeThree t3 = new TypeThree();
        t3.foo();
    }
}

/**
 * 动态绑定总是寻找最下层的进行绑定
 */
