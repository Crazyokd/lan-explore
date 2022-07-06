package com.sxrekord.generic.erase;

import java.util.*;

/**
 * @author Rekord
 * @date 2022/6/30 22:30
 */
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map= new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> p = new Particle<Long, Double>();
        System.out.println(Arrays.toString(
                list.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
                map.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
                quark.getClass().getTypeParameters()
        ));
        System.out.println(Arrays.toString(
                p.getClass().getTypeParameters()
        ));
    }
}


class Frob {}

class Fnorkle {}

class Quark<Q> {}

class Particle<POSITION, MOMENTUM> {}

// output
//[E]
//[K, V]
//[Q]
//[POSITION, MOMENTUM]
