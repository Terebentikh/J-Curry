package com.functional.curry;

import org.javatuples.Pair;

import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;

/**
 * a class that holds functions that breaks down tuple into parameters, but it swaps the order of
 * the parameters, so it passes the first value in the tuple as the second argument in
 * the function, and passes the second value in the tuple as the first argument
 * <p>
 * Created by Ahmed Adel Ismail on 2/21/2018.
 */
public class SwapTuples {

    /**
     * pass the {@link Pair#getValue0()} as the second parameter to the given {@link BiConsumer},
     * and {@link Pair#getValue1()} as the first parameter
     *
     * @param biConsumer the {@link BiConsumer} that will handle the passed parameters
     * @param pair       the {@link Pair} that holds the parameters in the same order
     * @param <T1>       the type of the first parameter
     * @param <T2>       the type of the second parameter
     */
    public static <T1, T2> void withBiConsumer(BiConsumer<T1, T2> biConsumer, Pair<T2, T1> pair) {
        try {
            biConsumer.accept(pair.getValue1(), pair.getValue0());
        } catch (Throwable e) {
            throw new RuntimeExceptionConverter().apply(e);
        }
    }

    /**
     * pass the {@link Pair#getValue0()} as the second parameter to the given {@link BiFunction},
     * and {@link Pair#getValue1()} as the first parameter
     *
     * @param biFunction the {@link BiFunction} that will handle the passed parameters
     * @param pair       the {@link Pair} that holds the parameters in the same order
     * @param <T1>       the type of the first parameter
     * @param <T2>       the type of the second parameter
     * @param <R>        the expected return type
     * @return the result of the passed {@link BiFunction}
     */
    public static <T1, T2, R> R withBiFunction(BiFunction<T1, T2, R> biFunction, Pair<T2, T1> pair) {
        try {
            return biFunction.apply(pair.getValue1(), pair.getValue0());
        } catch (Throwable e) {
            throw new RuntimeExceptionConverter().apply(e);
        }
    }
}