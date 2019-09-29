package com.github.peacetrue.record;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiayx
 */
@Data
public class PropertyValueImpl<Type, Value> implements PropertyValue<Type, Value>, Serializable {

    private String name;
    private Type type;
    private Value value;
    
}
