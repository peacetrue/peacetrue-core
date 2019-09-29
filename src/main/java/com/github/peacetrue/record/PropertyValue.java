package com.github.peacetrue.record;

/**
 * 属性值
 *
 * @author xiayx
 */
public interface PropertyValue<Type, Value> {

    /** 获取属性名 */
    String getName();

    /** 获取属性类型 */
    Type getType();

    /** 获取属性值 */
    Value getValue();
}
