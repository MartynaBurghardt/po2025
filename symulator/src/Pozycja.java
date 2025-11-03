package symulator;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void aktualizujPozycje(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public String getPozycja() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
