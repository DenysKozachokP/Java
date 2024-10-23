package com.education.ztu;

public class Employee extends Person {
    private String position;
    private String company;
    private Car car;
    private int counter;
    public Employee() {
        super();
        this.position = "Інженер";
        this.company = "Google";
        this.car = new Car("BMW");
        this.counter++;
    }

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, String position, String company, Car car) {
        super(firstname, lastname, age, gender, location);
        this.position = position;
        this.company = company;
        this.car = car;
        this.counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("Я працівник.");
    }

    public void showCounter() {
        System.out.print(this.counter);
    }
}

