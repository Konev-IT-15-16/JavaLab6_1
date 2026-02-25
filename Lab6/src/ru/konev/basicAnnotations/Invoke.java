package ru.konev.basicAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для маркировки методов,
 * которые должны быть автоматически вызваны.
 * Применяется только к методам и доступна во время выполнения программы.
 */

@Target(value = ElementType.METHOD) // целью является метод
@Retention(value = RetentionPolicy.RUNTIME) // доступна во время выполнения программы
public @interface Invoke {
}