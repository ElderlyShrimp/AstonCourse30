package org.example;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate date;
    private String manufacturer;
    private String country;
    private double price;
    private boolean booking;

    public Product(String name, LocalDate date, String manufacturer, String country, double price, boolean booking){
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.booking = booking;
    }

    public void infoProduct(){
        System.out.println(name + ", " + date + ", " + manufacturer + ", " + country + ", " + price + ", " + booking);
    }
}
