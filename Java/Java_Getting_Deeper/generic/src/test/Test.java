package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void test(){
        ArrayList<Integer> input=null;
        List<Number> output=null;
        output=generic(input);
    }
    public static List<Person> ge(List<Student> s){
        return s;
    }
    public static <E extends Number>  List<? super E> generic(List<E> nums){

        return nums;
    }
    public static void main(String[] args){
        test();
        //A,返回值是List<? super Integer>,而ArrayList是List的子类，显然错误
//        ArrayList<Integer> input=null;
//        ArrayList<Integer> output=null;
//        output= process(input);
//        //B,<? super Integer>可能是Integer，也可能是Integer的父类，如果是后者,则二者是并列关系
//        ArrayList<Integer> input=null;
//        List<Integer> output=null;
//        output= process(input);
//        //C,<? super Integer>可能是Number，也可能是Number的父类或子类，如果是后者,则二者是并列关系
//        ArrayList<Integer> input=null;
//        List<Number> output=null;
//        output= process(input);
//        //D,ArrayList是List的子类，显然不能接收一个父类
//        List<Number> input=null;
//        ArrayList<Integer> output=null;
//        //E,<? super Number>可能是Number，也可能是Number的父类，如果是后者,则二者是并列关系
//        List<Number> input=null;
//        List<Number> output=null;
//        //F,<? super Integer>可能是Integer，也可能是Integer的父类，如果是后者,则二者是并列关系
        List<Integer> input=null;
        List<Integer> output=null;
        output  = process (input);
    }
    public static <E extends Number>  List<? super E> process(List<E> nums){
        return nums;
    }

    public static void setField(Student s,String fieldName,Object fieldValue) throws NoSuchFieldException, IllegalAccessException {
        Field field=s.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(s,fieldValue);
    }
}


