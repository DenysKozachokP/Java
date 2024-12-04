package com.education.ztu.Task_03;
import java.lang.reflect.*;
import java.util.*;


public class Main3 {
    public static void main(String[] args) {
        try {
            Class<?> clazz1 = Employee.class;
            Class<?> clazz2 = Class.forName("com.education.ztu.Task_03.Employee");
            Employee empInstance = new Employee();
            Class<?> clazz3 = empInstance.getClass();

            System.out.println("Отримання об'єкта Class трьома способами:");
            System.out.println(clazz1);
            System.out.println(clazz2);
            System.out.println(clazz3);

            System.out.println("\nПоля класу Employee:");
            Field[] fields = clazz1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Поле: " + field.getName() + ", Тип: " + field.getType());
            }

            System.out.println("\nМетоди класу Employee:");
            Method[] methods = clazz1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Метод: " + method.getName() +
                        ", Параметри: " + Arrays.toString(method.getParameterTypes()) +
                        ", Повертає: " + method.getReturnType());
            }

            System.out.println("\nКонструктори класу Employee:");
            Constructor<?>[] constructors = clazz1.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Конструктор: " + constructor.getName() +
                        ", Параметри: " + Arrays.toString(constructor.getParameterTypes()));
            }

            System.out.println("\nСтворення екземпляра класу:");
            Constructor<?> constructor = clazz1.getConstructor(String.class, int.class, String.class);
            Object employeeInstance = constructor.newInstance("Іван Іванович", 30, "Програміст");
            Method displayInfoMethod = clazz1.getMethod("displayInfo");
            displayInfoMethod.invoke(employeeInstance);  // Виклик методу displayInfo

            System.out.println("\nРобота з приватним полем 'name':");
            Field nameField = clazz1.getDeclaredField("name");
            nameField.setAccessible(true);  // Доступ до приватного поля
            nameField.set(employeeInstance, "Оновлене ім'я");  // Встановлення значення
            System.out.println("Оновлене значення: " + nameField.get(employeeInstance));  // Отримання значення

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
