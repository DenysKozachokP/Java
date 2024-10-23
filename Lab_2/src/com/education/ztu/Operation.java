package com.education.ztu;

public class Operation {
    public static int addition(int... values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int subtraction(int... values) {
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result -= values[i];
        }
        return result;
    }

    public static int multiplication(int... values) {
        int product = 1;
        for (int value : values) {
            product *= value;
        }
        return product;
    }

    public static float division(int... values) {
        float result = values[0];
        for (int i = 1; i < values.length; i++) {
            result /= values[i];
        }
        return result;
    }

    public static float average(int... values) {
        return (float) addition(values) / values.length;
    }

    public static int maximum(int... values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int minimum(int... values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}