package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            if (delimiterEnd != -1) {
                String delimiterPrefix = numbers.substring(2, delimiterEnd);
                if (delimiterPrefix.startsWith("[") && delimiterPrefix.endsWith("]")) {
                    delimiter = delimiterPrefix.substring(1, delimiterPrefix.length() - 1);
                } else {
                    delimiter = delimiterPrefix;
                }
                numbers = numbers.substring(delimiterEnd + 1);
            }
        }

        String[] numArray = numbers.split("\\Q" + delimiter + "\\E|,|\n");

        int sum = 0;

        List<Integer> negativeNumbers = new ArrayList<>();

        for (String num : numArray) {
            if (num.isEmpty()) {
                throw new IllegalArgumentException("Input contains consecutive delimiters or empty values");
            }

            int n = Integer.parseInt(num);

            if (n < 0) {
                negativeNumbers.add(n);
            }

            if (n <= 1000) {
                sum += n;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
