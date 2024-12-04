package com.education.ztu.Task_03;

class Employee {
    private String name;
    private int age;
    private String position;

    public Employee() {
        this.name = "Без імені";
        this.age = 0;
        this.position = "Без посади";
    }

    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Ім'я: " + name + ", Вік: " + age + ", Посада: " + position);
    }

    public void updatePosition(String newPosition) {
        this.position = newPosition;
        System.out.println("Посада оновлена: " + position);
    }

    private void secretMethod() {
        System.out.println("Це приватний метод.");
    }
}
