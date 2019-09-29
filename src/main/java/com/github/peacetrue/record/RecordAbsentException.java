package com.github.peacetrue.record;

import lombok.Getter;

import java.util.Objects;

/**
 * 指定记录不存在
 *
 * @author xiayx
 */
@Getter
public class RecordAbsentException extends RuntimeException {

    private Record record;

    public RecordAbsentException(Record record) {
        super(String.format("指定记录[%s]不存在", Objects.requireNonNull(record).toString()));
        this.record = record;
    }


}