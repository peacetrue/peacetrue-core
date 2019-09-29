package com.github.peacetrue.record;

import lombok.Getter;

import java.util.Objects;

/**
 * 指定记录已存在
 *
 * @author xiayx
 */
@Getter
public class RecordExistException extends RuntimeException {

    private Record record;

    public RecordExistException(Record record) {
        super(String.format("指定记录[%s]已存在", Objects.requireNonNull(record).toString()));
        this.record = record;
    }

}