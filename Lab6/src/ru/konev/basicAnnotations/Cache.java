package ru.konev.basicAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для пометки классов, которые поддерживают кэширование.
 * <p>
 * Позволяет указать области кэширования для класса с помощью параметра {@code value}.
 * </p>
 * @see java.lang.annotation.Retention
 * @see java.lang.annotation.Target
 */

@Target(value = ElementType.TYPE) // целью является тип
@Retention(value = RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения программы
public @interface Cache {
    /**
     * Массив строк, определяющий области кэширования.
     * Каждая строка представляет отдельную область кэша.
     *
     * <p>
     * Если значение не указано, используется конфигурация по умолчанию.
     * </p>
     *
     * @return массив строковых идентификаторов кэшей.
     */
    String[] value() default {};
}
