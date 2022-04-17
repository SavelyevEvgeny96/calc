package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Calc {
    static String[] convert = {
            "0",
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String result = calc(inputString);
        System.out.println(result);
    }

    private static String calc(String inputString) throws Exception {
        Scanner sc = new Scanner(inputString);
        String a = sc.next();
        String op = sc.next();
        String b = sc.next();
        if (sc.hasNext()) throw new Exception("Запись должна быть вида A + B");
        int num1;
        int num2;

        if (Arrays.asList(convert).contains(a) && Arrays.asList(convert).contains(b)) {
            num1 = Arrays.asList(convert).indexOf(a);
            num2 = Arrays.asList(convert).indexOf(b);
            if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1)
                throw new Exception("Калькулятор может работать только с числами от 1 до 10");
            int result = calculate(num1, num2, op);
            if (result < 1) throw new Exception("Римские числа не могу быть меньше I");
            return convert[result];

        }
        try {
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
        } catch (Exception e) {
            throw new Exception("Некорректно введенные данные");
        }
        if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1)
            throw new Exception("Калькулятор может работать только с числами от 1 до 10");
        int result = calculate(num1, num2, op);
        return String.valueOf(result);
    }

    static int calculate(int a, int b, String op) throws Exception {
        int result;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                throw new Exception("Введенная операция не поддерживается калькулятором");
        }
        return result;
    }


}
