package com.sxrekord.wwf.pkg1;

/**
 * @author Rekord
 * @date 2022/6/19 23:27
 */
public class PKG {
    void say() {
        System.out.println("I'm PKG");
    }
    protected void inherit() {
        System.out.println("This inherit method");
    }
}

class PKGAuxiliary {
    void say() {
        System.out.println("I'm PKGAuxiliary");
    }
    public static void aloudSay() {
        System.out.println("I'm PKGAuxiliary loudly");
    }
}
