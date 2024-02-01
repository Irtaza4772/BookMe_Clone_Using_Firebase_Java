package com.example.bookmeclone;

public class Book {

    String Name, Price, Date;

    public Book() {
    }

    public Book(String name, String price, String date) {
        Name = name;
        Price = price;
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
