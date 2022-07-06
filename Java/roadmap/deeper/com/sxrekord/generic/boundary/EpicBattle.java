package com.sxrekord.generic.boundary;

/**
 * @author Rekord
 * @date 2022/7/1 10:56
 */
interface SuperPower {}

interface XrayVision extends SuperPower {}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {

}

class CanineHero<POWER extends SuperHearing & SuperSmell> {

}
public class EpicBattle {
}
