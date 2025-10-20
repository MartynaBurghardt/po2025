import java.util.ArrayList;
import java.util.Random;

public class Lotto2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int num = random.nextInt(49) + 1;
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        System.out.println("Wylosowane: " + numbers);
    }
}