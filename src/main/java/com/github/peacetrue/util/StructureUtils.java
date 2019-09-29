package com.github.peacetrue.util;

import com.github.peacetrue.bean.CodeCapable;
import com.github.peacetrue.bean.IdCapable;
import com.github.peacetrue.bean.NameCapable;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * use {@link Stream} to represent {@code Collection} and {@code Array}
 *
 * @author xiayx
 * @see IdCapable
 * @see CodeCapable
 * @see NameCapable
 */
public abstract class StructureUtils {

    public static <T> Optional<T> findOptional(Stream<T> stream, Predicate<T> predicate) {
        return stream.filter(predicate).findAny();
    }

    public static <T> List<T> findList(Stream<T> stream, Predicate<T> predicate) {
        return stream.filter(predicate).collect(Collectors.toList());
    }

    public static <T, V> Optional<T> findOptional(Stream<T> stream, Function<T, V> valueGetter, @Nullable V propertyValue) {
        return stream.filter(t -> Objects.equals(propertyValue, valueGetter.apply(t))).findAny();
    }

    public static <T, V> List<T> findList(Stream<T> stream, Function<T, V> valueGetter, Supplier<Stream<V>> values) {
        return stream.filter(t -> values.get().anyMatch(v -> v.equals(valueGetter.apply(t)))).collect(Collectors.toList());
    }

    public static <I, T extends IdCapable<I>> Optional<T> findOptionalById(Stream<T> stream, @Nullable I id) {
        return findOptional(stream, IdCapable::getId, id);
    }

    public static <T extends IdCapable<I>, I> List<T> findListById(Stream<T> stream, Supplier<Stream<I>> ids) {
        return findList(stream, IdCapable::getId, ids);
    }

    public static <T extends CodeCapable> Optional<T> findOptionalByCode(Stream<T> stream, String code) {
        return findOptional(stream, CodeCapable::getCode, code);
    }

    public static <T extends CodeCapable> List<T> findListByCode(Stream<T> stream, Supplier<Stream<String>> codes) {
        return findList(stream, CodeCapable::getCode, codes);
    }


    public static <T extends CodeCapable & NameCapable> String findNameByCode(Stream<T> stream, String code) {
        //TODO java.lang.invoke.LambdaConversionException: Invalid receiver type interface com.github.peacetrue.core.CodeCapable; not a subtype of implementation type interface com.github.peacetrue.core.NameCapable
//        return findOptional(stream, CodeCapable::getCode, code).map(NameCapable::getName).orElse(null);
        Optional<T> optional = findOptional(stream, CodeCapable::getCode, code);
        return optional.isPresent() ? optional.get().getName() : null;
    }

    public static <T extends CodeCapable & NameCapable> String findNameByCode(T[] items, String code) {
        return findNameByCode(Arrays.stream(items), code);
    }


    public static boolean containsCode(Collection<? extends CodeCapable> collection, String code) {
        return !collection.isEmpty() && collection.stream().anyMatch(item -> item.getCode().equals(code));
    }

    @SafeVarargs
    public static <T extends CodeCapable> boolean containsCode(String code, T... array) {
        return containsCode(Arrays.asList(array), code);
    }

    public static <T extends NameCapable> Optional<T> findOptionalByName(Stream<T> stream, String name) {
        return findOptional(stream, NameCapable::getName, name);
    }

    public static <T extends NameCapable> List<T> findListByName(Stream<T> stream, Supplier<Stream<String>> names) {
        return findList(stream, NameCapable::getName, names);
    }

    public static boolean containsName(Collection<? extends NameCapable> collection, String name) {
        return collection.stream().anyMatch(item -> item.getName().equals(name));
    }

    @SafeVarargs
    public static <T extends NameCapable> boolean containsName(String name, T... array) {
        return containsName(Arrays.asList(array), name);
    }

    public boolean equals(IdCapable source, @Nullable Object target) {
        if (source == target) return true;
        if (!(target instanceof IdCapable)) return false;
        return equals(source, (IdCapable) target);
    }

    public boolean equals(@Nullable IdCapable<?> source, @Nullable IdCapable<?> target) {
        if (source == target) return true;
        return source != null && target != null && source.getId().equals(target.getId());
    }

}
