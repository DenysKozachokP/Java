package com.education.ztu;

public class Teacher extends Person {
    private String subject;
    private String university;
    private Car car;
    private int counter;

    public Teacher() {
        super();
        this.subject = "Математика";
        this.university = "Житомирський університет";
        this.car = new Car("Toyota");
        this.counter++;
    }

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        this.counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("Я вчитель.");
    }

    public void showCounter() {
        System.out.print(this.counter);
    }
}
