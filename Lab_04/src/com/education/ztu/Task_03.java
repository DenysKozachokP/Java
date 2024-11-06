package com.education.ztu;

public class Task_03 {
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 36;

        StringBuilder sb = new StringBuilder();

        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2).append("\n");
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2).append("\n");
        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2).append("\n");

        System.out.println("Рядок після використання append:");
        System.out.println(sb.toString());

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '=') {
                sb.deleteCharAt(i);
                sb.insert(i, "рівно");
            }
        }
        System.out.println("Рядок після заміни '=' на 'рівно' за допомогою insert() і deleteCharAt():");
        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2).append("\n");
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2).append("\n");
        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2).append("\n");

        int index;
        while ((index = sb.indexOf("=")) != -1) {
            sb.replace(index, index + 1, "рівно");
        }
        System.out.println("Рядок після заміни '=' на 'рівно' за допомогою replace():");
        System.out.println(sb.toString());

        sb.reverse();
        System.out.println("Рядок після зміни послідовності символів на протилежну:");
        System.out.println(sb.toString());

        System.out.println("Довжина рядка: " + sb.length());
        System.out.println("Capacity рядка: " + sb.capacity());
    }
}