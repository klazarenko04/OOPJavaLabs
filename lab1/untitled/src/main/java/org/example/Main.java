package org.example;

public class Main {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add("1000,999,1001"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}