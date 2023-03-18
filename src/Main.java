import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    protected static boolean[] czyNaLiscie = new boolean[52];
    public static void main(String[] args) {
        OneWayLinkedListWithHead<Karta> Karty = new OneWayLinkedListWithHead<>();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int wybor;
        while (run) {
            System.out.println("""
                    0 - Wyjdź\s
                    1 - Utwórz listę kart\s
                    2 - Wyświetl karty\s
                    3 - Policz ukryte i odkryte karty\s
                    4 - Wyświetl karty o podanej wartości\s
                    5 - Wyświetl karty o podanym kolorze\s
                    6 - Usuń ukryte karty\s""");
            wybor = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (wybor) {
                    case 0 -> run = false;
                    case 1 -> {Karty = GenerojKarty.generujKarty(); czyNaLiscie = new boolean[52];}
                    case 2 -> printKarty(Karty);
                    case 3 -> printNumberHidden(Karty);
                    case 4 -> {
                        System.out.println("Podaj szukaną wartość karty (wartość numeryczna):");
                        int wartosc = scanner.nextInt();
                        scanner.nextLine();
                        printKarty(kartyWartosci(Karty, wartosc));
                    }
                    case 5 -> {
                        System.out.println("""
                        Podaj szukany kolor karty (wartość numeryczna):
                        0-Karo
                        1-Kier
                        2-Trefl
                        3-Pik""");
                        int kolor = scanner.nextInt();
                        scanner.nextLine();
                        printKarty(kartyKoloru(Karty, kolor));
                    }
                    case 6 -> {
                        for (int i = 0; i < Karty.size(); i++) {
                            if (Karty.get(i).czyZakryta()) {
                                Karty.remove(i);
                                i--;
                            }
                        }
                    }
                    default -> System.out.println("Błędny numer opcji");

                }
            }
            catch ( java.util.InputMismatchException | java.lang.NumberFormatException e) {
                System.out.println("Wpisałeś błędny typ danych!");
                scanner.nextLine();
            }
        }




    }
    public static void printKarty(OneWayLinkedListWithHead<Karta> karty) {
        ListIterator<Karta> iterator  = karty.listIterator();
        if (!iterator.hasNext()) System.out.println("Brak kart do wyświetlenia");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getString());
        }
        System.out.println();
    }

    public static void printNumberHidden(OneWayLinkedListWithHead<Karta> karty) {
        System.out.println("Liczba kart w talii: "+karty.size()+"\nw tym:");
        //count cards with znacznik == true
        int count = 0;
        for (Karta karta : karty) { if (karta.czyZakryta()) count++; }
        System.out.println(count+" kart ukrytych");
        System.out.println(karty.size()-count+" kart odkrytych \n");

    }

    public static OneWayLinkedListWithHead<Karta> kartyKoloru(OneWayLinkedListWithHead<Karta> karty, int kolor) {
        OneWayLinkedListWithHead<Karta> kartyKoloru = new OneWayLinkedListWithHead<>();
        for (Karta sprawdzanaKarta : karty) {
            if (sprawdzanaKarta.getKolor() == kolor) {
                kartyKoloru.add(sprawdzanaKarta);
            }
        }
        return kartyKoloru;
    }

    public static OneWayLinkedListWithHead<Karta> kartyWartosci(OneWayLinkedListWithHead<Karta> karty, int wartosc) {
        OneWayLinkedListWithHead<Karta> kartyWartosci = new OneWayLinkedListWithHead<>();
        for (Karta sprawdzanaKarta : karty) {
            if (sprawdzanaKarta.getWartosc() == wartosc) {
                kartyWartosci.add(sprawdzanaKarta);
            }
        }
        return kartyWartosci;
    }
}