package symulator;

public class Main {
    public static void main(String[] args) {

        Silnik silnik = new Silnik("Toyota", "VVT-i", 6500);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Aisin", "Automat", 6);
        Sprzeglo sprzeglo = new Sprzeglo("Valeo", "Standard");
        Samochod samochod = new Samochod(silnik, skrzynia, sprzeglo);

        samochod.wlacz();
        sprzeglo.wcisnij();
        skrzynia.zwiekszBieg();
        sprzeglo.zwolnij();
        sprzeglo.wcisnij();
        skrzynia.zwiekszBieg();
        sprzeglo.zwolnij();
        sprzeglo.wcisnij();
        skrzynia.zmniejszBieg();
        sprzeglo.zwolnij();
        samochod.jedz(15, 10);
        samochod.jedz(-5, 3);
        samochod.wylacz();
    }
}
