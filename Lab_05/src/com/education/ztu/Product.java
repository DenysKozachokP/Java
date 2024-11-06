package com.education.ztu;

class Product {
    private String name;
    private double price;
    private String category;
    private int count;
    private double discount;

    public Product(String name, double price, String category, int count, int discount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.count = count;
        this.discount = discount;
    }

    public String getName() { return this.name; }
    public double getPrice() { return this.price; }
    public String getCategory() { return this.category; }
    public int getCount(){return this.count;}
    public double getDisount(){return this.discount;}

    @Override
    public String toString() {
        double finalprice = price - (price/100 * discount);
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "', count = " +count + ", discount = "+ discount + ", finalprice = "+ finalprice +"}";
    }
}