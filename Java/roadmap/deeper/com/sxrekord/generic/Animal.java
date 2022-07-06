package com.sxrekord.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rekord
 * @date 2022/7/5 10:53
 */
public class Animal {
}

class Cat extends Animal {
    public void show() {
        System.out.println("I am in Animal show()");
    }
}

class MiniCat extends Cat {
    private String name;
}

class AnimalTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        List<MiniCat> miniCats = new ArrayList<>();
        miniCats.add(new MiniCat());
        // compile error
//        testExtends(animals);

        testExtends(cats);
        testExtends(miniCats);

        System.out.println("----------------------------");
        testSuper(animals);
        testSuper(cats);
        // compile error
//        testSuper(miniCats);
    }

    public static void testExtends(List<? extends Cat> list) {
        // compile error
//        list.add(new Object());
//        list.add(new Animal());
//        list.add(new Cat());
//        list.add(new MiniCat());

        // compile error
//        List<Object> objects = (List<Object>)list;
//        List<String> strings = (List<String>)list;
//        List<Animal> animals = (List<Animal>)list;
        List<Cat> cats = (List<Cat>)list;
        List<MiniCat> miniCats = (List<MiniCat>)list;

        if (!list.isEmpty()) {
            // compile error
//            MiniCat miniCat = list.get(0);
            Cat cat = list.get(0);
            cat.show();
        }
    }

    public static void testSuper(List<? super Cat> list) {
        list.add(new Cat());
        list.add(new MiniCat());
//        list.add(new Animal());
//        list.add(new Object());

        for (Object o : list) {
            System.out.println(o);
        }

        List<Object> objects = (List<Object>)list;
        List<Animal> animals = (List<Animal>)list;
        List<Cat> cats = (List<Cat>)list;
//        List<String> strings = (List<String>)list;
//        List<MiniCat> miniCats = (List<MiniCat>)list;
    }
}

/** output
 * 1. <? super AnyType> 能添加元素，但要求这些元素必须是 AnyType 或其子类
 * 2. 支持强转，但只能强转为下限或下限的父类型
 * 3. 由于支持强转，故可能在代码中将其强转为下限的某一个父类型，所以只要添加的是下限或下限的子类型，那么整个过程就不会出问题。
 */