package ru.konev.classesAnnotation;

import ru.konev.basicAnnotations.Invoke;
import ru.konev.basicAnnotations.Two;

/**
 * Класс, предоставляющий мяукающего кота.
 * <p>
 * Класс помечен аннотацией {@link Two}, где
 * <ul>
 *     <li> first = имя кота. </li>
 *     <li> second = возраст кота.</li>
 * </ul>
 * </p>
 * @see Two
 */

@Two(first = "Барсик", second = 5)
public class Cat {
    private final String name;
    /**
     * Создает объект Cat с указанным именем.
     *
     * @param name Имя создаваемого объекта.
     */
    public Cat(String name) {
        this.name = name;
    }
    /**
     * Производит мяуканье.
     * Метод помечен аннотацией {@link Invoke} для автоматического вызова.
     */
    @Invoke
    public void meow() {
        System.out.println(name + ": мяу!");
    }
    /**
     * Возвращает строковое представление объекта Cat.
     * <p>
     * Формат: "Кот:" + имя кота.
     * </p>
     * @return Строковое представление объекта Cat.
     */
    @Override
    public String toString() {
        return "Кот: " + name;
    }
}
