package com.company;

import java.util.Scanner;

public class Main {

    public static String inputData(String variable) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть число " + variable + " у двійковому вигляді: ");
        String binaryNumber = input.nextLine();
        boolean isBinary = binaryNumber.matches("^[01]+$");
        if (!isBinary) {
            throw new IllegalArgumentException("Число не у двійковому вигляді!");
        }
        return binaryNumber;
    }

    public static int pow (int value, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result = result * value;
        }
        return result;
    }

    public static long binaryToDecimal (String binaryNumber) {
        char[] charArray = binaryNumber.toCharArray();
        long decimalNumber = 0;
        for (int i=0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                decimalNumber += pow(2, charArray.length - i - 1);
            }
        }
        return decimalNumber;
    }

    public static void main(String[] args) {
        try {
            String firstNumber = inputData("X");
            String secondNumber = inputData("Y");
            printResults(firstNumber, secondNumber);
        } catch (IllegalArgumentException e) {
            printException(e);
        }
    }

    static void printException (Exception exception) {
        System.out.println("EXCEPTION! " + exception.getMessage());
    }

    static void printResults(String firstNumber, String secondNumber) {
        long decimalNumber1 = binaryToDecimal(firstNumber);
        long decimalNumber2 = binaryToDecimal(secondNumber);
        if (decimalNumber1 % decimalNumber2 == 0) {
            System.out.println("Число " + decimalNumber1 + " націло ділиться на " + decimalNumber2);
        }
        else {
            System.out.println("Число " + decimalNumber1 + " націло не ділиться на " + decimalNumber2);
        }
    }
}
