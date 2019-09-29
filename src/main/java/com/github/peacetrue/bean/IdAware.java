package com.github.peacetrue.bean;

/**
 * can set a id
 *
 * @param <T> the type of id
 * @author xiayx
 * @see IdCapable
 */
public interface IdAware<T> {
    void setId(T id);
}
