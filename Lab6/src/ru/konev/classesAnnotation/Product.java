package ru.konev.classesAnnotation;

import ru.konev.basicAnnotations.Validate;
import ru.konev.basicAnnotations.Cache;

/**
 * Класс Product для демонстрации аннотаций @Validate и @Cache.
 * Представляет товар с названием, ценой и количеством.
 *
 * @see Validate
 * @see Cache
 */
@Validate({String.class, Double.class, Integer.class})
@Cache({"Товар", "Цена", "Количество"})

public class Product {
    private String name;
    private double price;
    private int quantity;
    /**
     * Создает новый объект Product с указанными параметрами.
     *
     * @param name название товара
     * @param price цена товара
     * @param quantity количество товара
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * Создает объект Product со значениями по умолчанию.
     * <p>Название: "Товар", цена: 0.0, количество: 0</p>
     */
    public Product() {
        this("Товар", 0.0, 0);
    }
}