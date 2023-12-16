package org.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            if (delimiterEnd != -1) {
                delimiter = numbers.substring(2, delimiterEnd);
                numbers = numbers.substring(delimiterEnd + 1);
            }
        }

        String[] numArray = numbers.split("[,\n" + delimiter + "]");

        int sum = 0;

        for (String num : numArray) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive delimiters or empty values");
            }

            int n = Integer.parseInt(num);
            sum += n;
        }

        return sum;
    }

}