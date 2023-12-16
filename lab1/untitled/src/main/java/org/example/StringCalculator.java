package org.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split(",");

        if (numArray.length > 2) {
            throw new IllegalArgumentException("Input contains more than 2 numbers");
        }

        int sum = 0;

        for (String num : numArray) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive commas");
            }

            int n = Integer.parseInt(num);
            sum += n;
        }

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add(""));
            System.out.println(calculator.add("1"));
            System.out.println(calculator.add("1,2"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}