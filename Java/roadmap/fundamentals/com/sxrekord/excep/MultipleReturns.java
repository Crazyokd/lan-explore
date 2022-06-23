//: exceptions/MultipleReturns.java
package com.sxrekord.excep; /* Added by Eclipse.py */

public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) return;
            System.out.println("Point 2");
            if(i == 2) return;
            System.out.println("Point 3");
            if(i == 3) return;
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
    }

    public static int g(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) return 3;
            System.out.println("Point 2");
            if(i == 2) return 2;
            System.out.println("Point 3");
            if(i == 3) return 1;
            System.out.println("End");
            return 0;
        } finally {
            System.out.println("Performing cleanup");
//            return 0;
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++) {
            f(i);
            System.out.println("the result of g(" + i + ") = " + g(i));
        }
    }
}

/* Output:
Initialization that requires cleanup
Point 1
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
End
Performing cleanup
*///:~
