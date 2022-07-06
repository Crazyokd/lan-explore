package com.sxrekord.generic.erase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Rekord
 * @date 2022/7/5 12:47
 */
public class Erasure<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <E> E show1(E e) {
        return e;
    }

    public <E extends Number> E show2(E e) {
        return e;
    }
}

class ErasureTest {
    public static void main(String[] args) {
        Erasure<Integer> integerErasure = new Erasure<>();
        Class<? extends Erasure> clz = integerErasure.getClass();
        Field[] declaredFields = clz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 打印成员变量的名称和类型
            System.out.println(field.getName() + ":" + field.getType().getSimpleName());
        }

        System.out.println("---------------------");
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.getReturnType().getSimpleName());
        }
    }
}

/** output
 * key:Number
 * ---------------------
 * getKey:Number
 * show1:Object
 * show2:Number
 * setKey:void
 */