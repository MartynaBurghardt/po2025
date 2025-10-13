import java.util.ArrayList;
import java.util.Random;

public class Zad2lab2 {
    public static void main(String[] args) {
        
        if (args.length != 6) {
            System.out.println("Użycie: java Lotto liczba1 liczba2 liczba3 liczba4 liczba5 liczba6");
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
                System.out.println("Podano niepoprawną liczbę: " + arg);
                return;
            }
        }

      
        Random random = new Random();
        ArrayList<Integer> drawnNumbers = new ArrayList<>();

        while (drawnNumbers.size() < 6) {
            int num = random.nextInt(49) + 1;
            if (!drawnNumbers.contains(num)) {
                drawnNumbers.add(num);
            }
        }

        
        int hits = 0;
        for (int n : userNumbers) {
            if (drawnNumbers.contains(n)) {
                hits++;
            }
        }

        
        System.out.println("Twoje typy: " + userNumbers);
        System.out.println("Wylosowane liczby: " + drawnNumbers);
        System.out.println("Liczba trafień: " + hits);
    }
}
