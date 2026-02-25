package ru.konev.main;

import ru.konev.validator.Validator;
import ru.konev.classesAnnotation.*;
import ru.konev.reflection.*;

import java.util.*;

/**
 * Главный класс приложения для демонстрации работы с аннотациями и рефлексией.
 * <p>Предоставляет меню для выбора различных задач по работе с аннотациями.</p>
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Validator validator = new Validator();
        String catName;

        while (true) {
            System.out.println("ГЛАВНОЕ МЕНЮ ПРИЛОЖЕНИЯ");
            System.out.println("1) Задача 1.1: Аннотация @Invoke");
            System.out.println("2) Задача 1.2: Аннотация @Default");
            System.out.println("3) Задача 1.3: Аннотация @ToString");
            System.out.println("4) Задача 1.4: Аннотация @Validate");
            System.out.println("5) Задача 1.5: Аннотация @Two");
            System.out.println("6) Задача 1.6: Аннотация @Cache");
            System.out.println("7) Задача 2.2: Тест @Invoke");
            System.out.println("8) Задача 2.4: Тест @Two");
            System.out.println("0) Выход");
            System.out.print("Выберите задачу: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    // Задача 1.1: Аннотация @Invoke
                    scanner.nextLine();
                    System.out.println("\n" + "-".repeat(40));
                    System.out.println("Задача 1.1: Аннотация @Invoke");
                    System.out.println("-".repeat(40));
                    System.out.println("В данном задании необходимо создать своего кота - " +
                            "ввести имя коту. Далее будет применена аннотация @Invoke для автоматического вызова" +
                            " метода meow().");
                    System.out.print("Введите имя кота: ");
                    catName = validator.validateString();

                    try {
                        Cat userCat = new Cat(catName);
                        System.out.println("Создан объект: " + userCat);
                        System.out.println("Вызываем методы, отмеченные @Invoke:");
                        InvokeReflection.showInvoke(userCat);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;

                case "2":
                    // Задача 1.2: Аннотация @Default
                    scanner.nextLine();
                    System.out.println("Задача 1.2: Аннотация @Default");
                    System.out.println("В данном задании необходимо создать объект Person. " +
                            "Будет показан класс по умолчанию из аннотации @Default.");
                    System.out.print("Введите имя: ");
                    String name = validator.validateString();

                    System.out.print("Введите возраст (число): ");
                    int age = validator.validatePositiveInteger();

                    System.out.print("Введите пароль (только буквы и пробелы): ");
                    String password = validator.validateString();

                    System.out.print("Введите должность (только буквы и пробелы): ");
                    String role = validator.validateString();

                    try {
                        Person person = new Person(name, age, password, role);
                        System.out.println("Создан объект: " + person);
                        System.out.println("Извлекаем информацию из аннотации @Default:");
                        DefaultReflection.showDefault(person);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case "3":
                    // Задача 1.3: Аннотация @ToString
                    scanner.nextLine();
                    System.out.println("Задача 1.3: Аннотация @ToString");
                    System.out.println("В данном задании необходимо создать объект Person. " +
                            "Будет показано строковое представление с учетом аннотации @ToString.");
                    System.out.print("Введите имя: ");
                    String name3 = validator.validateString();

                    System.out.print("Введите возраст (число): ");
                    int age3 = validator.validatePositiveInteger();

                    System.out.print("Введите пароль (только буквы и пробелы): ");
                    String password3 = validator.validateString();

                    System.out.print("Введите должность (только буквы и пробелы): ");
                    String role3 = validator.validateString();

                    try {
                        Person person = new Person(name3, age3, password3, role3);
                        System.out.println("Создан объект: " + person);
                        System.out.println("Формируем строковое представление с учетом @ToString:");
                        ToStringReflection.showToString(person);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case "4":
                    // Задача 1.4: Аннотация @Validate
                    scanner.nextLine();
                    System.out.println("Задача 1.4: Аннотация @Validate");
                    System.out.println("В данном задании необходимо создать товар (Product). " +
                            "Будут показаны классы, указанные в аннотации @Validate.");

                    System.out.print("Введите название товара: ");
                    String productName = validator.validateString();

                    System.out.print("Введите цену товара (может быть дробным числом): ");
                    double price = validator.validateDouble();

                    System.out.print("Введите количество товара (целое число): ");
                    int quantity = validator.validateInteger();

                    try {
                        // Создаем объект Product
                        Product product = new Product(productName, price, quantity);
                        System.out.println("Создан товар: " + product);

                        // Вызываем обработчик, который выводит классы из аннотации
                        System.out.println("Классы-валидаторы из аннотации @Validate:");
                        ValidateReflection.showValidation(product);

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case "5":
                    // Задача 1.5: Аннотация @Two
                    scanner.nextLine();
                    System.out.println("Задача 1.5: Аннотация @Two");
                    System.out.println("В данном задании необходимо создать своего кота - ввести имя коту. " +
                            "Затем будет применена аннотация @Two для хранения имени и возраста.");
                    System.out.print("Введите имя кота: ");
                    catName = validator.validateString();

                    try {
                        Cat userCat = new Cat(catName);
                        // Выводим информацию о созданном объекте
                        System.out.println("Создан объект: " + userCat);
                        // Вызываем обработчик аннотации @Two
                        System.out.println("Извлекаем значения из аннотации @Two:");
                        TwoReflection.ShowTwo(userCat);

                        // Дополнительно показываем, что значения из аннотации отличаются от введенных
                        System.out.println("\nОбратите внимание: в аннотации @Two указаны другие значения:");
                        System.out.println("  first = \"Барсик\" (имя по умолчанию)");
                        System.out.println("  second = 5 (возраст по умолчанию)");
                        System.out.println("А вы ввели имя: \"" + catName + "\"");

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;

                case "6":
                    // Задача 1.6: Аннотация @Cache
                    scanner.nextLine();
                    System.out.println("Задача 1.6: Аннотация @Cache");
                    System.out.println("В данном задании необходимо создать товар (Product). " +
                            "Будут показаны области кэширования из аннотации @Cache.");

                    System.out.print("Введите название товара: ");
                    String productName6 = validator.validateString();

                    System.out.print("Введите цену товара (может быть дробным числом): ");
                    double price6 = validator.validateDouble();

                    System.out.print("Введите количество товара (целое число): ");
                    int quantity6 = validator.validateInteger();

                    try {
                        // Создаем объект Product (уже имеет аннотацию @Cache)
                        Product product = new Product(productName6, price6, quantity6);
                        System.out.println("Создан товар: " + product);

                        // Вызываем обработчик аннотации @Cache
                        System.out.println("Области кэширования из аннотации @Cache:");
                        CacheReflection.showCache(product);

                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                    case "7":
                        scanner.nextLine();
                        System.out.println("Задача 2.2: Тест  @Invoke");
                        System.out.println("Работу тестирования можно посмотреть в пакете tests/TestInvoke");
                        System.out.println();
                    break;

                case "8":
                    scanner.nextLine();
                    System.out.println("Задача 2.6: Тест @Two");
                    System.out.println("Работу тестирования можно посмотреть в пакете tests/TestTwo");
                    break;

                case "0":
                    System.out.println("\nВыход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nНеверный выбор! Пожалуйста, выберите номер от 0 до 8.");
            }

            System.out.println("\nНажмите 'Enter' чтобы вернуться в главное меню...");
            scanner.nextLine();
        }
    }
}