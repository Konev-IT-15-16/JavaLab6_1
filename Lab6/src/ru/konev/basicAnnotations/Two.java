package ru.konev.basicAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для хранения пары значений: строкового {@link #first()}
 * и числового {@link #second()}.
 * Может применяться только к типам (классам, интерфейсам, перечислениям).
 * Доступна во время выполнения программы.
 */

@Target(value = ElementType.TYPE) // целью является тип
@Retention(value = RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения
public @interface Two {
    /**
     * Обязательное строковое свойство.
     *
     * @return строковое значение
     */
    String first();

    /**
     * Обязательное числовое свойство.
     *
     * @return целочисленное значение
     */
    int second();
}
