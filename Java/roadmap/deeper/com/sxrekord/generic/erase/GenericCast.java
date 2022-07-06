package com.sxrekord.generic.erase;

/**
 * @author Rekord
 * @date 2022/7/4 13:02
 */
public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        String[] str = "A B C D E F G H I J".split(" ");
        for (String s : str) {
            strings.push(s);
        }

        // compile ok
//        test1(strings);

        // compile ok
        test2(strings);

        testObject();
    }

    public static void test1(FixedSizeStack<String> strings) {
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }

    public static void test2(FixedSizeStack<String> strings) {
        for (int i = 0; i < SIZE; i++) {
            Object o = strings.pop();
            System.out.println(o instanceof String);
        }
    }

    public static void testObject() {
        // 以下实验表名哪怕使用强转，也无法覆盖实际的类型信息
        Object str = "hello";
        System.out.print("str instanceof String ? ");
        System.out.println(str instanceof String);
        Object obj = (Object)str;
        System.out.print("obj instanceof String ? ");
        System.out.println(obj instanceof String);

        FixedSizeStack<Object> objectFixedSizeStack = new FixedSizeStack<>(SIZE);
        objectFixedSizeStack.push(new String("hello"));
        System.out.println(objectFixedSizeStack.pop() instanceof String);
    }

    public static void testCast() {
        FixedSizeStack<Object> objectFixedSizeStack = new FixedSizeStack<>(SIZE);
        FixedSizeStack<String> stringFixedSizeStack = new FixedSizeStack<>(SIZE);
        // compile error
//        objectFixedSizeStack = (FixedSizeStack<Object>)stringFixedSizeStack;
        FixedSizeStack fixedSizeStack = new FixedSizeStack(SIZE);

        fixedSizeStack = stringFixedSizeStack;
        fixedSizeStack = objectFixedSizeStack;

        // class<T> 继承至 class
        // class<K> 与 class<V> 之间是同层次关系，即使 K 与 V 之间存在继承或实现关系
    }
}

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    public T pop() {
        return (T)storage[--index];
    }
}


/**
 * 保证编译时程序正确性
 * 运行时自动强转
 */