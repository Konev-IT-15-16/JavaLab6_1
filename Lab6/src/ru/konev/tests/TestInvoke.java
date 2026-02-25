package ru.konev.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.konev.classesAnnotation.Cat;
import ru.konev.reflection.InvokeReflection;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс, проверяющий корректность работы аннотации {@link ru.konev.basicAnnotations.Invoke}
 * и механизма вызова в классе {@link InvokeReflection}
 */
public class TestInvoke {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Проверяет корректность вызова метода, помеченного аннотацией {@link ru.konev.basicAnnotations.Invoke}
     * при вызове метода {@link InvokeReflection#showInvoke(Object)}.
     * @see InvokeReflection
     */
    @Test
    void testInvoke() {
        Cat cat = new Cat("Мурзик");
        InvokeReflection.showInvoke(cat);
        String result = outputStream.toString().trim();
        // Проверяем, что метод был вызван и вывел ожидаемый текст
        assertEquals("Мурзик: мяу!", result);
    }

    /**
     * Проверяет, что метод {@link InvokeReflection#showInvoke(Object)}
     * корректно обрабатывает объект без методов с аннотацией {@link ru.konev.basicAnnotations.Invoke}
     * (не должно быть исключений и вывода в консоль)
     * @see InvokeReflection
     */
    @Test
    void testInvokeOnClassWithoutAnnotatedMethods() {
        // Создаем простой класс без аннотаций
        class SimpleClass {
            @SuppressWarnings("unused")
            public void someMethod() {
                System.out.print("Не должно быть выведено");
            }
        }

        SimpleClass obj = new SimpleClass();

        // Не должно быть исключений
        assertDoesNotThrow(() -> InvokeReflection.showInvoke(obj));

        // Не должно быть вывода в консоль
        String result = outputStream.toString().trim();
        assertTrue(result.isEmpty());
    }
}