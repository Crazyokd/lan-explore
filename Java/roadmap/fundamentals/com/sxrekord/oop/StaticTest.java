package com.sxrekord.oop;

/**
 * @author Rekord
 * @date 2022/6/20 16:10
 */

class TypeOne {
    static int a = 5;
    int aa = 11;
    private int dd = 44;

    public static void f() {
        System.out.println("TypeOne f()");
    }

    public static void g() {
        System.out.println("TypeOne g()");
    }

    public void foo() {
        System.out.println("TypeOne foo()");
    }
}

class TypeTwo extends TypeOne {
    static int b = a*a;
    int bb = 33;
    int aa = 22;
    int dd = 55;

    public static void f() {
        System.out.println("TypeTwo f()");
    }

    public final void foo() {
        System.out.println("TypeTwo foo()");
    }

    public int getAA() {
        return aa;
    }
    public int getSuperAA() {
        return super.aa;
    }
}

class TypeThree extends TypeTwo{
    public static void g() {
        System.out.println("TypeThree g()");
    }

}

public class StaticTest {
    public static void main(String[] args) {
        System.out.println("TypeTwo: " + TypeTwo.a);
        System.out.println("typeTwo: " + new TypeTwo().a);
        TypeTwo.a = 10;
        System.out.println("TypeOne: " + TypeOne.a);

        TypeOne t1 = new TypeTwo();
        System.out.println(t1.aa);
//        System.out.println(t1.dd);

        // test static method
        t1.f();


        TypeTwo t2 = new TypeThree();
        t2.g();


        // field cover
        TypeTwo typeTwo = new TypeTwo();
        System.out.println(typeTwo.aa);
        System.out.println(typeTwo.getAA());
        System.out.println(typeTwo.getSuperAA());
    }
}

/* output:
TypeTwo: 5
        typeTwo: 5
        TypeOne: 10
        11
        TypeOne f()
        TypeOne g()
        22
        22
        11
*/

/**
 * static 域也会被继承
 * 域 不参与动态绑定
 * 静态方法 不参与动态绑定
 * 由于 static 域会被继承，且其不参与动态绑定，故 static 域也存在“掩盖”现象
 */
