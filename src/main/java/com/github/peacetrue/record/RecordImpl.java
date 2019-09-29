package com.github.peacetrue.record;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiayx
 */
@Data
public class RecordImpl<Type> implements Record<Type>, Serializable {

    private Type type;
    private List<PropertyValue> propertyValues;

}
