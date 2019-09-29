package com.github.peacetrue.operator;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiayx
 */
@Data
public class OperatorImpl<T> implements Operator<T>, Serializable {
    private T id;
    private String name;
}
