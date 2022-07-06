package com.sxrekord.generic.erase;

/**
 * @author Rekord
 * @date 2022/6/30 22:59
 */
public class Foo<T extends Bar> {
    T var;
    public Foo(T t) {
        var = t;
    }

    public void foo() {
        System.out.println("foo");
        System.out.println(var.bar());
    }
}

class Bar {
    final int value = 5;
    public static void main(String[] args) {
        Foo<Bar> foo = new Foo<>(new Bar());
        System.out.println(foo instanceof Foo);
        // compile error
//        System.out.println(foo instanceof Foo<Bar>);
        System.out.println(foo.var);
        System.out.println(foo.var.value);
        System.out.println(foo.var instanceof Bar);
        System.out.println(foo.var instanceof Object);
        foo.foo();
    }
    public String bar() {
        System.out.println("bar");
        return "bar";
    }
}
