import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.nCopies;

public class Calculator {

    Map<String, Integer> romeArabianMap = new HashMap<>();

    public Calculator() {
        romeArabianMap.put("I", 1);
        romeArabianMap.put("II", 2);
        romeArabianMap.put("III", 3);
        romeArabianMap.put("IV", 4);
        romeArabianMap.put("V", 5);
        romeArabianMap.put("VI", 6);
        romeArabianMap.put("VII", 7);
        romeArabianMap.put("VIII", 8);
        romeArabianMap.put("IX", 9);
        romeArabianMap.put("X", 10);
    }

    public int parseRomeToArabic(String rome) {
        if (romeArabianMap.containsKey(rome)) {
            return romeArabianMap.get(rome);
        }
        throw new RuntimeException("Not existing roman number");
    }

    public String parseArabicToRome(int rome) {
        return String.join("", nCopies(rome, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }

    public int arabicNumbers(int a, int b, String operator) {
        if (a > 10 || b > 10) {
            throw new RuntimeException("Number more than 10");
        }
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        throw new RuntimeException("Not supported operation");
    }

    public String romeNumbers(String a, String b, String operator) {

        int numb1 = parseRomeToArabic(a);
        int numb2 = parseRomeToArabic(b);
        int result = switch (operator) {
            case "+" -> numb1 + numb2;
            case "-" -> numb1 - numb2;
            case "*" -> numb1 * numb2;
            case "/" -> numb1 / numb2;
            default -> 0;
        };
        return parseArabicToRome(result);
    }
}

