package symulator;

public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;

    public SkrzyniaBiegow(String producent, String model, int iloscBiegow) {
        super(producent, model);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
    }

    public void zwiekszBieg() {
        if (aktualnyBieg < iloscBiegow) {
            aktualnyBieg++;
            System.out.println("Zwiększono bieg na: " + aktualnyBieg);
        } else {
            System.out.println("Nie można zwiększyć — to już najwyższy bieg!");
        }
    }

    public void zmniejszBieg() {
        if (aktualnyBieg > 0) {
            aktualnyBieg--;
            System.out.println("Zmniejszono bieg na: " + aktualnyBieg);
        } else {
            System.out.println("Nie można zmniejszyć — już jest luz!");
        }
    }

    public void wyzerujBieg() {
        aktualnyBieg = 0;
        System.out.println("Bieg zresetowany do pozycji neutralnej (luz).");
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }
}
