package com.sxrekord.generic.erase;

/**
 * @author Rekord
 * @date 2022/7/1 9:03
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        System.out.println(new Building().getClass().isInstance(new House()));
        System.out.println(new Building() instanceof House);

        ClassTypeCapture<Building> ctc1 = new ClassTypeCapture(Building.class);
        System.out.println(ctc1.f(new Building()));
        System.out.println(ctc1.f(new House()));

        ClassTypeCapture<House> ctc2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctc2.f(new Building()));
        System.out.println(ctc2.f(new House()));
    }
}

class Building {}
class House extends Building {}