package ru.konev.validator;

import ru.konev.basicAnnotations.Two;
import ru.konev.reflection.TwoReflection;

/**
 * Валидатор для проверки корректности значений аннотации @Two.
 * Расширяет функциональность класса {@link TwoReflection}.
 */
public class TwoValidator {

    /**
     * Проверяет корректность значений аннотации @Two для указанного класса.
     *
     * @param clazz класс для проверки
     * @throws IllegalArgumentException если значения некорректны
     */
    public static void validateTwoAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Two.class)) {
            throw new IllegalArgumentException(
                    "Класс " + clazz.getSimpleName() + " не содержит аннотацию @Two");
        }

        Two two = clazz.getAnnotation(Two.class);
        String first = two.first();
        int second = two.second();

        // Сбор всех ошибок валидации
        StringBuilder errors = new StringBuilder();

        // Проверка строкового значения
        if (first == null || first.trim().isEmpty()) {
            errors.append("Строковое свойство first (имя) не может быть пустым или состоять только" +
                    " из пробелов. ");
        }

        // Проверка числового значения
        if (second < 0) {
            errors.append("Числовое свойство second (возраст) не может быть отрицательным. ");
        }

        // Дополнительная проверка для котов - возраст не должен быть больше 30
        if (second > 30) {
            errors.append("Числовое свойство second (возраст) не может быть больше 30" +
                    " (кошачий возраст). ");
        }

        // Если есть ошибки, выбрасываем исключение
        if (errors.length() > 0) {
            throw new IllegalArgumentException("Обнаружены ошибки в аннотации @Two класса " +
                    clazz.getSimpleName() + ": " + errors.toString().trim());
        }
    }

    /**
     * Безопасная версия метода ShowTwo из класса TwoReflection.
     * Перед выводом проверяет корректность значений.
     *
     * @param object объект для анализа
     * @throws IllegalArgumentException если значения некорректны
     */
    public static void showTwoSafely(Object object) {
        validateTwoAnnotation(object.getClass());
        // Если валидация пройдена, вызываем оригинальный метод
        TwoReflection.ShowTwo(object);
    }

    /**
     * Получает проверенные значения аннотации.
     *
     * @param object объект для анализа
     * @return массив из двух значений [first, second]
     * @throws IllegalArgumentException если значения некорректны
     */
    public static Object[] getValidatedValues(Object object) {
        validateTwoAnnotation(object.getClass());

        Two two = object.getClass().getAnnotation(Two.class);
        return new Object[]{two.first(), two.second()};
    }
}