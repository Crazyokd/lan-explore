//: polymorphism/PrivateOverride.java
// Trying to override a private method.

/**
 * @author Rekord
 * @date 2022/6/20 16:01
 */

package com.sxrekord.oop;

public class PrivateOverride {
    private void f() {
        System.out.println("private f()"); }
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        po.g();
        invokePrivate();
    }
    private void g() {
        System.out.println("private g()");
    }

    public static void invokePrivate() {
        PrivateOverride po = new PrivateOverride();
        po.f();
        po.g();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()"); }
}
/* Output:
private f()
*///:~

class PrivateOverrideTest {
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        // po.f();
        // po.g();
    }
}