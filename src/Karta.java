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

    public int getWartosc() { return Wartosc; }

    public void setWartosc(int wartosc) { this.Wartosc = wartosc; }

    public int getKolor() { return Kolor; }

    public void setKolor(int kolor) { this.Kolor = kolor; }

    public boolean czyZakryta() { return !Znacznik; }

    public void setZnacznik(boolean znacznik) { this.Znacznik = znacznik; }
    //nie definiuje konstruktora domyślnego, bo nie będę go używał w żadnym scenariuszu.
}
