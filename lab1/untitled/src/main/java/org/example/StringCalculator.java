package org.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split(",");

        int sum = 0;

        for (String num : numArray) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive commas or empty values");
            }

            int n = Integer.parseInt(num);
            sum += n;
        }

        return sum;
    }


}