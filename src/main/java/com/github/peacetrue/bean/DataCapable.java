package com.github.peacetrue.bean;

/**
 * the object which has a data property.
 * the data property represents the actual effective data.
 *
 * @param <T> the type of data
 * @author xiayx
 */
public interface DataCapable<T> {

    /**
     * get the unique program identification code
     *
     * @return the id
     */
    T getData();
}
