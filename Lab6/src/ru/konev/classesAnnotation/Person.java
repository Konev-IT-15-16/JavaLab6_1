package ru.konev.classesAnnotation;

import ru.konev.basicAnnotations.Default;
import ru.konev.basicAnnotations.ToString;
import ru.konev.basicAnnotations.Mode;

/**
 * Класс Person для демонстрации аннотаций @Default и @ToString.
 * <p>Содержит информацию о человеке: имя, возраст, пароль и должность.</p>
 *
 * @see Default
 * @see ToString
 */

@Default(Person.class)
@ToString
public class Person {
    private String name;
    private int age;

    @ToString(Mode.NO)
    private String password;

    private String role;

    /**
     * Создает объект Person с указанными данными.
     *
     * @param name Имя
     * @param age Возраст
     * @param password Пароль (будет скрыт в toString)
     * @param role Должность
     */
    public Person(String name, int age, String password, String role) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this("Иван", 20, "", "");
    }
}
