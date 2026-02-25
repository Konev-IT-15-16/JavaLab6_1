package ru.konev.basicAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания списка классов-валидаторов, которые должны применяться
 * для проверки объектов данного типа или других аннотаций.
 * <p>
 * Массив строк {@code value} может использоваться для указания
 * конкретных имен классов или аннотаций, которые будут включены
 * в проверку или обработку аннотации.
 * </p>
 */

@Target({ElementType.TYPE, ElementType.FIELD}) // целью является тип или поле
@Retention(value = RetentionPolicy.RUNTIME) // аннотация доступна во время выполнения
public @interface Validate {
    /**
    * Обязательное свойство, указывающее массив классов-валидаторов.
    *
    * @return массив классов, включенных в данную аннотацию.
    */
 Class<?>[] value();
}
