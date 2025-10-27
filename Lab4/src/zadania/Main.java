package zadania;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fillZooRandomly();
        zoo.showAnimals();
        System.out.println("Total legs: " + zoo.getTotalLegs());
    }
}
