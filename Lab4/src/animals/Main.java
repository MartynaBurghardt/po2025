package animals;

public class Main {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("Polly");
        Dog dog = new Dog("Rex");
        Snake snake = new Snake("Slither");

        System.out.println(parrot.getDescription());
        System.out.println(dog.getDescription());
        System.out.println(snake.getDescription());
    }
}
