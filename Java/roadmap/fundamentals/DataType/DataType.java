/**
 * @author Rekord
 * @date 2022/6/17 13:28
 */
public class DataType {
    public static void main(String[] args) {
        System.out.println("We will not use 'Hello, World!'");

        // use L suffix for long
        System.out.println(4000000000000000000L);

        // from Java 7, These underline will be ignoring by the compiler
        System.out.println(0B1010_0101_101_000111_001);
        System.out.println(123_123_123);

        // use D suffix for double(default)
        System.out.println(3.14D);
        // use F suffix for float
        System.out.println(3.14F);


        // test the type of char
        System.out.println('a');
        System.out.println("abc\bd");
        System.out.println('\u2122');
        System.out.println('\u03C0');
        System.out.println('\u0022');

        // Unicode escape sequences will be translated to the corresponding characters before parse code.
        System.out.println("\u0022+\u0022");

        // test String
        String str1 = "123";
        String str2 = "123";
        System.out.println(str1 == str2); // true

        String str3 = new String("123");
        String str4 = new String("123");
        System.out.println(str3 == str4); // false
        System.out.println(str3.equals(str4)); // true

        // boolean type
        boolean b1 = true;
        boolean b2 = false;
    }
}
