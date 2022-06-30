/**
 * @author Rekord
 * @date 2022/6/20 17:19
 */

package com.sxrekord.oop;

class Meal {
    Meal() {
        System.out.println("Meal()"); }
    Meal(int index) {
        System.out.println("Meal() " + index);
    }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
    private Cheese cheese = new Cheese();
    Lunch() {
        System.out.println("Lunch()");
    }
    Lunch(int index) {
        System.out.println("Lunch() " + index);
    }
    private static int print() {
        System.out.println("Lunch print()");
        return 0;
    }
    static {
        System.out.println("Lunch static init block");
    }
    private static int print = print();
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
    PortableLunch(int index) {
        super(index);
        System.out.println("PortableLunch " + index);
    }
}

public class Sandwich extends PortableLunch {
    private static int print = print();
    private Bread b = new Bread();
    private PortableLunch c = new PortableLunch();
    public Sandwich() {
        super(1);
        System.out.println("Sandwich()");
    }

    {
        System.out.println("PortableLunch init block");
    }
    private Lettuce l = new Lettuce();
    public static void main(String[] args) {
        new Sandwich();
    }
    private static int print() {
        System.out.println("Sandwich print()");
        return 0;
    }
}

/* Output:
Lunch static init block
Lunch print()
Sandwich print()
Meal()
Cheese()
Lunch() 1
PortableLunch 1
Bread()
Meal()
Cheese()
Lunch()
PortableLunch()
PortableLunch init block
Lettuce()
Sandwich()
*///:~


/**
 * 1. 通过查看 extends 关键字决定是否继续向上加载基类
 * 2. 通过第一步能够得到一个加载类的列表 classList
 * 3. 从最高基类开始往下加载执行 static 域 与 static初始化块 (二者加载顺序从上到下，不分优先级)【此过程会遍历完第二步的加载类列表classList】
 * 4. 从最高基类开始往下加载 域 与 一些初始化块(不分优先级），最后是构造器
 * 5. 第四步并不会加载所有构造器，而是仅加载 “调用到的构造器”
 */