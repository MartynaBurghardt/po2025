package animals;

public abstract class Animal {
    public String name;
    public int legs;

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }
    public int getLegs() {
        return this.legs;
    }
    public void makeSound() {
        System.out.println("Zwierzę wydaje dźwięk.");
    }

    public abstract String getDescription();
}
