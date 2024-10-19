package main.java;

public class Logic {

    public float setArithmetic(char op, float num1, float num2) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '×' -> num1 * num2;
            case '÷' -> num1 / num2;
            default -> num1;
        };
    }

    public static int getDecimalLength(double num) {
        int counter = 0;
        while ((num % 1) != 0) {
            num *= 10;
            counter++;
        }
        return counter;
    }
}
