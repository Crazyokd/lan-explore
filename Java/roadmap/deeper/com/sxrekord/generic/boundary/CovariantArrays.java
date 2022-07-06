package com.sxrekord.generic.boundary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rekord
 * @date 2022/7/1 11:03
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        testNonCovariantGeneric();
        testUnboundedWildcards();
    }

    public static void testNonCovariantGeneric() {
        // compile error
//        List<Fruit> flist = new ArrayList<Apple>();
    }

    public static void testCovariantGeneric() {
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // compile error
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());

        flist.add(null);

        Fruit f = flist.get(0);
    }

    public static void testUnboundedWildcards() {
        // compile error
        // require ?, provide Fruit or Apple
        List<?> list1 = new ArrayList<>();
//        list1.add(new Fruit());
//        list1.add(new Apple());
//        list1.add(new Object());

        List list2 = new ArrayList();
        list2.add(new Fruit());
        list2.add(new Apple());
    }
}
