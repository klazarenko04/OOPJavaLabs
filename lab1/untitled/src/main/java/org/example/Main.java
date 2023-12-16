package org.example;

public class Main {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add("//[***][**][*]\n1***23**11*1"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}