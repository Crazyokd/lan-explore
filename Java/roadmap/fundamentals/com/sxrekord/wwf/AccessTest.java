package com.sxrekord.wwf;

import com.sxrekord.wwf.pkg1.PKG;

/**
 * @author Rekord
 * @date 2022/6/19 23:23
 */
public class AccessTest {
    public static void main(String[] args) {
        PKG pkg = new PKG();
        Access access = new Access();
        access.myInherit();
    }

}

class Access extends PKG {
    void myInherit() {
        super.inherit();
    }
}
