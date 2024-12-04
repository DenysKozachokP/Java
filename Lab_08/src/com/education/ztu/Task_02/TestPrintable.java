package com.education.ztu.Task_02;

public class TestPrintable {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Lambda");
        printable.print();
    }
}