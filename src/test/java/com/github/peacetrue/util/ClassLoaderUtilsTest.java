package com.github.peacetrue.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiayx
 */
public class ClassLoaderUtilsTest {

    @Test
    public void loadClass() {
        byte[] bytes = ClassLoaderUtils.loadClass(ClassLoaderUtilsTest.class.getName());
        System.out.println(bytes);
    }

    @Test
    public void loadClass1() {
    }
}