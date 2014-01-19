package ohha.ohha;

import hahmot.hirvio;
import hahmot.pelaaja;
import java.util.Scanner;
import logiikka.hahmo;
import logiikka.hirvioGeneraattori;
import logiikka.kuolema;

public class testi {

    private hahmo p;
    public hirvioGeneraattori hg;

    public testi() {
        this.p = new pelaaja();
        this.hg = new hirvioGeneraattori();
    }

    public void run() {
        Scanner l = new Scanner(System.in);
        kuolema ku = new kuolema();

        hg.lisaa(1);

        //PELIKENTTÄ
        while (true) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if (p.getX() == j && p.getY() == i) {
                        System.out.print("O");
                    } else if (hg.getLista().get(0).getX() == j && hg.getLista().get(0).getY() == i) {
                        System.out.print("H");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println("");
            }

            //PELAAJAN LIIKE
            String k = l.nextLine();
            if (k.equals("d")) {
                p.siirra(1, 0);
            }
            if (k.equals("s")) {
                p.siirra(0, 1);
            }
            if (k.equals("a")) {
                p.siirra(-1, 0);
            }
            if (k.equals("w")) {
                p.siirra(0, -1);
            }
            if (k.equals("x")) {
                break;
            }

            //HIRVIÖN LIIKE. (0,0) KOSKA LIIKE ARVOTAAN ITSE METODISSA
            for (hahmo h1 : hg.getLista()) {
                h1.siirra(0, 0);
            }

            //TARKISTUS ONKO PELAAJA ELOSSA
            //(koordinaatit täytyy viedä luokkaan jotta tarkistus toimii)
            for (hahmo h1 : hg.getLista()) {
                if (ku.pelaajakuollut(p.getX(), p.getY(), h1.getX(), h1.getY()) == true) {
                    break;
                }
            }

            //KOORDINAATIT
            System.out.println("pelaaja: " + p.getX() + " " + p.getY());
        }
    }
}
