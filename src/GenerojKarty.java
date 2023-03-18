import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class GenerojKarty {

    public static OneWayLinkedListWithHead<Karta> generujKarty() {

        //Tworzę pierwszą kartę
        OneWayLinkedListWithHead<Karta> karty = new OneWayLinkedListWithHead<>();
        int wartosc = ThreadLocalRandom.current().nextInt(1, 13);
        int kolor = ThreadLocalRandom.current().nextInt(0, 3);
        karty.add(new Karta(wartosc, kolor));

        for(;;) {
            wartosc = ThreadLocalRandom.current().nextInt(0, 15);
            if (wartosc == 0) {break;}
            kolor = ThreadLocalRandom.current().nextInt(0, 3);
            ListIterator<Karta> iterator  = karty.listIterator();

            if (Main.czyNaLiscie[kolor*13+wartosc-1]) { continue;} // Sprawdzam, czy karta już istnieje
            Main.czyNaLiscie[kolor*13+wartosc-1] = true; // Jeżeli nie istnieje, to dodaje ją do listy istniejących.
            while(true) {
                if (!iterator.hasNext()) {iterator.add(new Karta(wartosc, kolor)); break;} // Jeżeli jestem na końcu listy, to dodaje tutaj.
                Karta nastepna = iterator.next();
                iterator.previous(); // cofam o jedno, bo pobranie wartości następnej karty przesunęło iterator
                if (nastepna.getWartosc() > wartosc) {iterator.add(new Karta(wartosc,kolor)); break;}
                if (nastepna.getWartosc() == wartosc && nastepna.getKolor() < kolor) {iterator.next(); continue;}
                if (nastepna.getWartosc() == wartosc && nastepna.getKolor() >= kolor) { iterator.add(new Karta(wartosc, kolor)); break;}
                if (nastepna.getWartosc() < wartosc) {iterator.next();}
            }

        }
        System.out.println("Talia "+karty.size()+ " kart wygenerowana"+"\n");

        return karty;
    }
}
