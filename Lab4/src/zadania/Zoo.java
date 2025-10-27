package zadania;

import animals.Animal;
import animals.Parrot;
import animals.Dog;
import animals.Snake;

import java.util.Random;

public class Zoo {
    private Animal[] animals = new Animal[100];
    private int count = 0;
    private Random random = new Random();

    public void fillZooRandomly() {

        String[] parrotNames = {"Polly", "Kiki", "Rio"};
        String[] dogNames = {"Rex", "Burek", "Fido"};
        String[] snakeNames = {"Slither", "Nagini", "Kaa"};

        for (int i = 0; i < animals.length; i++) {
            int choice = random.nextInt(3);

            switch (choice) {
                case 0:
                    animals[i] = new Parrot(parrotNames[random.nextInt(parrotNames.length)]);
                    break;
                case 1:
                    animals[i] = new Dog(dogNames[random.nextInt(dogNames.length)]);
                    break;
                case 2:
                    animals[i] = new Snake(snakeNames[random.nextInt(snakeNames.length)]);
                    break;
            }
            int legs = animals[i].getLegs();
            count++;
        }
    }

    public void showAnimals() {
        for (int i = 0; i < count; i++) {
            System.out.println(animals[i].getDescription());
            animals[i].makeSound();
        }
    }

    public int getTotalLegs() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += animals[i].getLegs();
        }
        return sum;
    }
}