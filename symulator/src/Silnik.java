package symulator;

public class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;

    public Silnik(String producent, String model, int maxObroty) {
        super(producent, model);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }


    public void wlacz() {
        uruchom();
    }

    public void wylacz() {
        zatrzymaj();
    }


    public void uruchom() {
        obroty = 800;
        System.out.println("Silnik " + getProducent() + " " + getModel() + " uruchomiony. Obroty: " + obroty);
    }

    public void zatrzymaj() {
        obroty = 0;
        System.out.println("Silnik zatrzymany.");
    }

    public int getObroty() {
        return obroty;
    }

    public int getMaxObroty() {
        return maxObroty;
    }

    @Override
    public String toString() {
        return "Silnik{" +
                "producent='" + getProducent() + '\'' +
                ", model='" + getModel() + '\'' +
                ", obroty=" + obroty +
                ", maxObroty=" + maxObroty +
                '}';
    }
}
