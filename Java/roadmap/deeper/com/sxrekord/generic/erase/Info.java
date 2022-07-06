package com.sxrekord.generic.erase;

import java.lang.reflect.Method;

/**
 * @author Rekord
 * @date 2022/7/5 20:20
 */
public interface Info<T> {
    T info(T t);
}

class InfoImpl implements Info<Integer> {
    @Override
    public Integer info(Integer t) {
        return t;
    }
}

class InfoTest {
    public static void main(String[] args) {
        Class<InfoImpl> infoClass = InfoImpl.class;
        Method[] methods = infoClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.getReturnType().getSimpleName());
        }
    }
}

/** output
 * info:Integer
 * info:Object
 */
