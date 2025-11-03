package symulator;

public class Samochod {
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;


    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
    }

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia) {
        this(silnik, skrzynia, null);
    }

    public Silnik getSilnik() { return silnik; }
    public SkrzyniaBiegow getSkrzynia() { return skrzynia; }
    public Sprzeglo getSprzeglo() { return sprzeglo; }

    @Override
    public String toString() {
        return "Samochod{silnik=" + silnik + ", skrzynia=" + skrzynia + ", sprzeglo=" + sprzeglo + "}";
    }
    public void jedz(int predkosc, int czas) {

        System.out.println("Jedziemy: prędkość=" + predkosc + ", czas=" + czas);

    }
    public void wlacz() {
        if (silnik != null) silnik.wlacz();
    }
    public void wylacz() {
        if (silnik != null) silnik.wylacz();
    }
}
