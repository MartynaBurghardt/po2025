import java.util.ArrayList;
import java.util.Random;

public class Lotto6full {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Użycie: java Lotto6full liczba1 liczba2 liczba3 liczba4 liczba5 liczba6");
            return;
        }

        ArrayList<Integer> userNumbers = new ArrayList<>();
        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                if (num < 1 || num > 49) {
                    System.out.println("Liczby muszą być w zakresie 1–49!");
                    return;
                }
                if (!userNumbers.contains(num)) {
                    userNumbers.add(num);
                } else {
                    System.out.println("Liczby nie mogą się powtarzać!");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawna liczba: " + arg);
                return;
            }
        }

        Random random = new Random();
        int attempts = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> drawnNumbers;

        while (true) {
            attempts++;
            drawnNumbers = new ArrayList<>();
            while (drawnNumbers.size() < 6) {
                int num = random.nextInt(49) + 1;
                if (!drawnNumbers.contains(num)) {
                    drawnNumbers.add(num);
                }
            }
            if (drawnNumbers.containsAll(userNumbers)) {
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Twoje liczby: " + userNumbers);
        System.out.println("Wylosowane liczby (pełne trafienie): " + drawnNumbers);
        System.out.println("Liczba losowań potrzebnych do pełnego trafienia: " + attempts);
        System.out.println("Czas działania programu: " + elapsedTime + " ms");
    }
}
