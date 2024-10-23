package main.java;

public class Logic {

    public double getResult(String input) {
        char[] chars = input.toCharArray();
        char op = '#';
        double num1 = 0;
        double num2 = 0;
        short decimal = 0;
        boolean pointSet = false;

        for (char symbol : chars) {
            switch (symbol) {
                case '+', '-', '×', '÷':
                    op = symbol;
                    pointSet = false;
                    decimal = 0;
                    break;

                case '.':
                    pointSet = true;
                    break;

                case '0','1','2','3','4','5','6','7','8','9':
                    if (op == '#') {
                        num1 = numberFormat(symbol, num1, pointSet, decimal);
                    } else {
                        num2 = numberFormat(symbol, num2, pointSet, decimal);
                    }
                    if (pointSet) decimal++;
                    break;
                default:
                    break;
            }
        }
        return setArithmetic(op, num1, num2);
    }

    public double setArithmetic(char op, double num1, double num2) {

        // debug *remove later
        System.out.println(num1);
        System.out.println(op);
        System.out.println(num2);

        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '×' -> num1 * num2;
            case '÷' -> num1 / num2;
            default -> num1;
        };
    }

    public double numberFormat(char symbol, double number, boolean pointSet, int decimal) {
        if (pointSet) { // the '.' button was pressed
            number = ((number * (10 ^ decimal)) + ((double) symbol - 48)) / (10 ^ decimal);
        } else if (number != 0) {
            number = ((number * 10) + (double) symbol - 48) / 10;
        } else {
            number = symbol - 48;
        }
        return number;
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
