package ru.konev.reflection;
import ru.konev.basicAnnotations.Two;

/**
 * Класс, выводящий значения, указанные в аннотации {@link Two}
 */
public class TwoReflection {
    /**
     * Выводит значения полей, указанных в аннотации {@link Two}
     * над переданным объектом.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Two}
     * @see Two
     */
    public static void ShowTwo(Object object) {
        Class <?> myClass = object.getClass();

        if (!myClass.isAnnotationPresent(Two.class)) {
            System.out.println("Класс " + myClass.getSimpleName() +
                    " не содержит аннотацию @Two");
            return;
        }

        Two annotation = myClass.getAnnotation(Two.class);
        String first = annotation.first();
        int second = annotation.second();

        // Проверяем на некорректные значения
        if (first == null || first.trim().isEmpty()) {
            System.out.println("Внимание: имя не указано (пустая строка)");
        }

        if (second < 0) {
            System.out.println("Внимание: возраст отрицательный");
        }

        System.out.println(first + ", " + second + " лет");
    }

    /**
     * Возвращает значения аннотации в виде строки.
     *
     * @param object объект для анализа
     * @return строковое представление значений
     */
    public static String getTwoAsString(Object object) {
        Class<?> myClass = object.getClass();

        if (!myClass.isAnnotationPresent(Two.class)) {
            return "Аннотация @Two отсутствует";
        }

        Two annotation = myClass.getAnnotation(Two.class);
        return annotation.first() + ", " + annotation.second() + " лет";
    }
}