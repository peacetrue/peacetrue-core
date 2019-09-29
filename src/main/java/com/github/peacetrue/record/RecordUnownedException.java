package com.github.peacetrue.record;

import lombok.Getter;

import java.util.Objects;

/**
 * 指定记录不被拥有
 *
 * @author xiayx
 */
@Getter
public class RecordUnownedException extends RuntimeException {

    private Record record;

    public RecordUnownedException(Record record) {
        super(String.format("指定记录[%s]不被拥有", Objects.requireNonNull(record).toString()));
        this.record = record;
    }

}