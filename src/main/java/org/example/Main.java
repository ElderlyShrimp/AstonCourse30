package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        Product product1 = new Product("HyperX", LocalDate.of(2025, 5, 15), "HP Inc", "USA", 10000, true);
        product1.infoProduct();
        System.out.println();

        // Задание 2
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("HyperX Cloud Core Wireless",
                LocalDate.of(2026, 2, 10),
                "HP Inc",
                "USA",
                8990,
                true);

        productsArray[1] = new Product("HyperX Cloud Flight",
                LocalDate.of(2026, 1, 5),
                "HP Inc",
                "USA",
                12590,
                false);

        productsArray[2] = new Product("HyperX Cloud Buds",
                LocalDate.of(2025, 12, 1),
                "HP Inc",
                "USA",
                5190,
                false);

        productsArray[3] = new Product("Cloud II Wireless",
                LocalDate.of(2025, 7, 21),
                "HP Inc",
                "USA",
                9990,
                true);

        productsArray[4] = new Product("Cloud Stinger S",
                LocalDate.of(2024, 9, 18),
                "HP Inc",
                "USA",
                15990,
                true);

        // Задание 3
        Park park1 = new Park("Диво-остров", "Санкт-Петербург");

        Park.Attraction attraction1 = park1.new Attraction("Бустер", 1000.0, "10:00-23:00");
        Park.Attraction attraction2 = park1.new Attraction("Шейкер", 300.0, "09:30-23:00");

        park1.getAttractions().add(attraction1);
        park1.getAttractions().add(attraction2);

        System.out.println(park1.getName() + " " + park1.getLocation());
        for (Park.Attraction att : park1.getAttractions()) {
            System.out.println("Аттракцион: " + att.getName());
            System.out.println("Цена: " + att.getPrice() + " рублей");
            System.out.println("Режим работы: " + att.getOperatingMode());
            System.out.println();
        }
    }
}