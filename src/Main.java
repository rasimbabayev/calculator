import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            String[] line = scanner.nextLine().split(" ");
            try {
                int numb1 = Integer.parseInt(line[0]);
                int numb2 = Integer.parseInt(line[2]);
                String operator = line[1];
                System.out.println(calculator.arabicNumbers(numb1, numb2, operator));
            } catch (NumberFormatException e) {
                String numb1 = line[0];
                String numb2 = line[2];
                String operator = line[1];
                System.out.println(calculator.romeNumbers(numb1, numb2, operator));
            }
        }
    }
}