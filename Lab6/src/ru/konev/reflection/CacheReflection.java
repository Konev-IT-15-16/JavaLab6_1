package ru.konev.reflection;
import  ru.konev.basicAnnotations.Cache;
import java.util.Arrays;
/**
 * Класс, выводящий список всех кэшируемых областей,
 * указанных в аннотации {@link Cache}.
 */
public class CacheReflection {
    /**
     * Выводит в консоль список областей, указанных в аннотации {@link Cache},
     * расположенных над классом переданного объекта.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации {@link Cache}
     * @throws IllegalArgumentException если аннотация @Cache не найдена или список
     * кэшируемых областей пуст.
     * @see Cache
     */
    public static void showCache(Object object) {
        Class <?> myClass = object.getClass();
        Cache annotation = myClass.getAnnotation(Cache.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Cache не найдена.");
        }
        String[] areas = annotation.value();
        if (areas.length == 0) {
            System.out.println("Список кэшируемых областей пуст.");
        } else {
            System.out.println("Кэшируемые области: " + Arrays.toString(areas));
        }
    }
}
