package com.drlee.unit10_innerclass.test1;

/**
 * 选择器接口
 */
public interface Selector {
    boolean end();
    Object current();
    void next();
}
