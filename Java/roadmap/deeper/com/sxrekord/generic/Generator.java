package com.sxrekord.generic;

/**
 * @author Rekord
 * @date 2022/6/30 16:34
 */
public interface Generator<T> {
    /**
     * 生成对象
     * @return
     */
    T next();
}

