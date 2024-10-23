package com.education.ztu;

public class Student extends Person {
    private String course;
    private String speciality;
    private String university;
    private int counter;

    public Student() {
        super();
        this.course = "1";
        this.speciality = "Інформатика";
        this.university = "Київський університет";
        this.counter++;
    }

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String course, String speciality, String university) {
        super(firstname, lastname, age, gender, location);
        this.course = course;
        this.speciality = speciality;
        this.university = university;
        this.counter++;
    }

    public void getOccupation() {
        System.out.println("Я студент.");
    }

    public void showCounter() {
        System.out.print(this.counter);
    }
}
