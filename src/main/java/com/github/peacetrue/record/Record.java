package com.github.peacetrue.record;

import java.util.List;

/**
 * 记录表示一个具体的实体信息
 *
 * @author xiayx
 */
public interface Record<Type> {

    /** 获取记录类型 */
    Type getType();

    /** 获取属性值列表 */
    List<PropertyValue> getPropertyValues();
}
