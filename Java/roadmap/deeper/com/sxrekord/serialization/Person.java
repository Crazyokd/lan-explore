package com.sxrekord.serialization;

import java.io.*;

/**
 * @author Rekord
 * @date 2022/7/6 10:01
 */
public class Person extends Company implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private transient double height;
    static private String skinColour;

    public Person() {}

    public String getSkinColour() {
        return skinColour;
    }

    public void setSkinColour(String skinColour) {
        Person.skinColour = skinColour;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class PersonTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        readObject();
    }

    public static void test1() {
        Person p = new Person();
        writeObject(p);
    }

    public static void test2() {
        Person p = new Person(12, "jim");
        p.setCompanyName("alibaba");
        writeObject(p);
        readObject();
    }

    public static void test3() {
        Person p = new Person(12, "Jim");
        p.setCompanyName("alibaba");
        p.setHeight(1.72);
        writeObject(p);
        readObject();
    }

    public static void test4() {
        Person p = new Person(12, "Jim");
        p.setCompanyName("alibaba");
        p.setHeight(1.72);
        p.setSkinColour("黄皮肤");
        writeObject(p);
    }

    public static void writeObject(Person p) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("ser.ser"));
            objectOutputStream.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObject() {
        ObjectInputStream objectInputStream = null;
        Person p = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("ser.ser"));
            p = (Person)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Unserializable Person Name: " + p.getName());
        System.out.println("Unserializable Person Age: " + p.getAge());
        System.out.println("Unserializable Person companyName: " + p.getCompanyName());
        System.out.println("Unserializable Person Height: " + p.getHeight());
        System.out.println("Unserializable Person skinColour: " + p.getSkinColour());
    }
}

class Company {
    private String companyName;

    public void setCompanyName(String name) {
        companyName = name;
    }

    public String getCompanyName() {
        return companyName;
    }
}