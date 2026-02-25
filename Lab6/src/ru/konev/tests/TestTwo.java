package ru.konev.tests;

import org.junit.jupiter.api.*;
import ru.konev.basicAnnotations.Two;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки обработки некорректных значений аннотации @Two.
 */
public class TestTwo {

    /**
     * Тестовый класс для проверки обработки некорректных значений аннотации @Two.
     */
    @Nested
    @DisplayName("Тест обработки некорректных значений аннотации @Two")
    class TwoInvalidValuesTest {

        /**
         * Вспомогательный класс с некорректными значениями в аннотации @Two:
         * first = "" (пустая строка), second = -1 (отрицательное число)
         */
        @Two(first = "", second = -1)
        private static class InvalidAnnotatedClass {
            // Пустой класс для тестирования
        }

        /**
         * Метод валидации, который проверяет корректность значений аннотации.
         * Если значения некорректны (first пустая или second < 0),
         * выбрасывает IllegalArgumentException.
         *
         * @param clazz класс для проверки
         * @throws IllegalArgumentException если значения аннотации некорректны
         */
        private void validateTwoAnnotation(Class<?> clazz) {
            // Получаем аннотацию через Reflection
            Two twoAnnotation = clazz.getAnnotation(Two.class);

            if (twoAnnotation == null) {
                throw new IllegalArgumentException("Класс не содержит аннотацию @Two");
            }

            String first = twoAnnotation.first();
            int second = twoAnnotation.second();

            // Проверяем условия и выбрасываем исключение при нарушении
            if (first == null || first.trim().isEmpty() || second < 0) {
                throw new IllegalArgumentException(
                        "Некорректные значения в аннотации @Two: " +
                                "first='" + first + "', second=" + second
                );
            }
        }

        /**
         * Тест проверяет, что при чтении аннотации с некорректными значениями
         * выбрасывается IllegalArgumentException с использованием assertThrows
         */
        @Test
        @DisplayName("Проверка с использованием assertThrows")
        void testInvalidTwoAnnotationWithAssertThrows() {
            Class<?> clazz = InvalidAnnotatedClass.class;

            // Проверяем, что метод validateTwoAnnotation выбрасывает исключение
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> validateTwoAnnotation(clazz),
                    "Должно быть выброшено исключение для некорректных значений"
            );

            // Проверяем сообщение исключения
            String message = exception.getMessage();
            assertTrue(message.contains("first=''") || message.contains("second=-1"),
                    "Сообщение об ошибке должно содержать информацию о некорректных значениях");

            // Выводим информацию для наглядности
            System.out.println("Тест пройден успешно!");
            System.out.println("Перехвачено исключение: " + message);
        }
    }
}