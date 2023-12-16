package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterPrefix);
                    List<String> delimiters = new ArrayList<>();
                    while (matcher.find()) {
                        delimiters.add(Pattern.quote(matcher.group(1)));
                    }
                    delimiter = String.join("|", delimiters);
                } else {
                    delimiter = Pattern.quote(delimiterPrefix);
                }
                numbers = numbers.substring(delimiterEnd + 1);
            }
        }

        String[] numArray = numbers.split(delimiter + "|,|\n");

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
