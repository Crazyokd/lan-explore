package com.sxrekord.generic.erase;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;

/**
 * @author Rekord
 * @date 2022/6/30 17:54
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
    }


}
