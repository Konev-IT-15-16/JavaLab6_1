package ru.konev.basicAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания класса по умолчанию.
 * <p>
 * Может применяться к типам (классам) или полям.
 * Обработчик во время программы считывает значение свойства {@code value} и выводит имя
 * указанного класса по умолчанию.
 * Доступна во время выполнения программы.
 * </p>
 */

@Target({ElementType.TYPE, ElementType.FIELD}) // целью является тип или поле
@Retention(value = RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения
public @interface Default {
    /**
     * Обязательное свойство, указывающее класс по умолчанию.
     *
     * @return Тип(класс), указанный как значение по умолчанию.
     */
    Class<?> value();
}
