package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/6/30 12:08
 */
public abstract class Pet {
    /**
     * 发出声音
     */
    public abstract void say();
}

class Dog extends Pet{
    @Override
    public void say() {
        System.out.println("汪汪汪");
    }
}
