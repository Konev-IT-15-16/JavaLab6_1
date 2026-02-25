package ru.konev.validator;
import java.util.*;
/**
 * Класс для проверки пользовательского ввода.
 * <p>Предоставляет методы для проверки корректности вводимых данных.</p>
 */
public class Validator {
    Scanner scanner = new Scanner(System.in);
    // Проверяет и получает целое число.
    public int validateInteger() {
        int validateNumber;
        String line;
        while (true) {
            line = scanner.nextLine();
            try {
                validateNumber = Integer.parseInt(line);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число повторно.");
            }
        }
        return validateNumber;
    }
    // Проверяет, что введена строка, представляющая целое число, но возвращает её как String.
    public String validateStringInteger() {
        int validateNumber;
        String line;
        while (true) {
            line = scanner.nextLine();
            try {
                validateNumber = Integer.parseInt(line);
                System.out.println();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число повторно.");
            }
        }
        return line;
    }
    // Проверяет и получает дробное число (double).
    public double validateDouble() {
        double validateNumber;
        String line;
        while (true) {
            line = scanner.nextLine();
            try {
                validateNumber = Double.parseDouble(line);
                System.out.println();
                break;
            } catch (NumberFormatException e){
                System.out.println("Ошибка: введите дробное число повторно.");
            }
        }
        return  validateNumber;
    }
    // Проверяет строку на не пустую строку и на разрешенные символы
    public String validateString() {
        String line;
        boolean valid;
        while (true) {
            line = scanner.nextLine();
            if (line != null) {
                line = line.trim();
            }

            // Проверка на пустую строку после trim()
            if (line == null || line.isEmpty()) {
                System.out.println("Ошибка: введите непустую строку.");
                continue;
            }

            valid = true;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (!Character.isLetter(ch) && ch != ' ' ) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return line;
            } else {
                System.out.println("Ошибка: введите строку из букв и/или пробелов.");
            }
        }
    }
    public int validatePositiveInteger() {
        int number;
        while (true) {
            number = validateInteger();

            if (number >= 0) {
                return number;
            } else {
                System.out.println("Ошибка: введите неотрицательное число.");
            }
        }
    }
}