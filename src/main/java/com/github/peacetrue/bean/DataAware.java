package com.github.peacetrue.bean;

/**
 * @author xiayx
 * @see DataAware
 */
public interface DataAware<T> {
    void setData(T data);
}
