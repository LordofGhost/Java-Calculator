package main.java;

public class Logic {

    public double getResult(String input) {
        char[] chars = input.toCharArray();
        char op = '#';
        double num1 = 0;
        double num2 = 0;
        short decimal = 1;
        boolean pointSet = false;

        for (char symbol : chars) {
            switch (symbol) {
                case '+', '-', '×', '÷':
                    if (op != '#') num1 = setArithmetic(op, num1, num2);
                    op = symbol;
                    pointSet = false;
                    decimal = 0;
                    num2 = 0;
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
        return op != '#' ? setArithmetic(op, num1, num2) : num1;
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
            number = (((number * 10) * (Math.pow(10, (decimal-1)))) + ((double) symbol - 48)) / (Math.pow(10, decimal));
        } else if (number != 0) {
            number = (number * 10) + ((double) symbol - 48);
        } else {
            number = symbol - 48;
        }
        return number;
    }
}
