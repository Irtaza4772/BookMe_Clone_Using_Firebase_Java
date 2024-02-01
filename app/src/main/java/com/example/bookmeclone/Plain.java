package com.example.bookmeclone;

public class Plain {

    String Name, From, To, Date, Price;

    public Plain() {
    }

    public Plain(String name, String from, String to, String date, String price) {
        Name = name;
        From = from;
        To = to;
        Date = date;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
