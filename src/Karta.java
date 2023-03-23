public class Karta {
    private int Wartosc;
    private int Kolor;
    private boolean Znacznik;

    public Karta(int wartosc, int kolor) {
        this.Wartosc = wartosc;
        this.Kolor = kolor;
        this.Znacznik = wartosc!=14;
    }
    public String getString() {
        if (!Znacznik) {return "( )";}
        String kolor = Integer.toString(Kolor);
        String wartosc = Integer.toString(Wartosc);
        switch (Kolor) {
            case 0 -> kolor = "Kier";
            case 1 -> kolor = "Karo";
            case 2 -> kolor = "Trefl";
            case 3 -> kolor = "Pik";
        }
        switch (Wartosc) {
            case 1 -> wartosc = "As";
            case 11 -> wartosc = "Walet";
            case 12 -> wartosc = "Dama";
            case 13 -> wartosc = "Król";
        }
        return wartosc + " " + kolor;

    }
    // Tylko gettery, setery nie będą używane.
    public int getWartosc() { return Wartosc; }

    public int getKolor() { return Kolor; }

    public boolean czyZakryta() { return !Znacznik; }

    //nie definiuje konstruktora domyślnego, bo nie będę go używał w żadnym scenariuszu.
}
