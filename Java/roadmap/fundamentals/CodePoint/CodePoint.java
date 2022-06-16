/**
 * This code is used to test the code point of the character.
 * @version 1.0 2022-06-16
 * @author Rekord
 */

// Code Point
// Code Unit
public class CodePoint {
    public static void main(String[] args) {
        // 码点(Unicode code point / character)是指一个编码表中的某个字符对应的代码值。
        // 所以一个字符串中的码点数(CodePointCount)即等于字符数

        // Unicode的码点分为17个代码级别，第一个级别是基本的多语言级别，码点从U+0000——U+FFFF，
        // 其余的16个级别从U+10000——U+10FFFF，其中包括一些辅助字符。
        // 基本的多语言级别，每个字符用16位表示代码单元，而辅助字符采用连续的一对连续代码单元进行编码。

        // 代码单元即在具体编码形式中的最小单位
        // 比如，UTF-16 中一个代码单元为16位，UTF-8 中一个代码单元为8位。
        // String 的 length 方法 是以 代码单元 为单位计数，故一个字符串的 length >= codePointCount

        String hello = "h𝕆i";
        System.out.println(hello.length());//4
        System.out.println(hello.codePointCount(0, hello.length()));//3
        System.out.println(hello.codePointBefore(4)); // 识别前一个码点


        for (int i = 0; i < hello.length(); i++) {
            char c = hello.charAt(i);
            System.out.println(c + ": " + Integer.toHexString(c));
        }
        System.out.println('\u997e' + " " + '\u6662');

        int codePointCount = hello.codePointCount(0, hello.length());
        for(int i = 0; i < codePointCount; i++) {
            int index = hello.offsetByCodePoints(0, i);
            int charAt = hello.codePointAt(index);
            System.out.println("index: " + index + "; HexValue: " + Integer.toHexString(charAt));
        }
        boolean isValid = Character.isValidCodePoint(0x997e);
        System.out.println(isValid);

        String str_en = "Hello, World!";
        String str_cn = "你好，世界！";

        System.out.println(str_cn.length()); // 6
        System.out.println(str_cn.codePointCount(0, str_cn.length())); // 6

//        char ch = '𝕆';
        char[] chars = Character.toChars(0x1d546);
        String str = new String(chars);
        System.out.println(str);
    }
}