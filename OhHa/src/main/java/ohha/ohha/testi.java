package ohha.ohha;

import hahmot.hirvio;
import hahmot.pelaaja;
import java.util.Scanner;
import logiikka.hahmo;
import logiikka.hirvioGeneraattori;
import logiikka.kuolema;
import logiikka.voimakentta;

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
        voimakentta vk = new voimakentta();

        //HIRVIÖIDEN LKM (+1)
        hg.lisaa(5);

        while (true) {

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
            if (k.equals("e")) {
                vk.hyokkaa(p.getX(), p.getY());
            }
            if (k.equals("x")) {
                break;
            }

            //HIRVIÖN LIIKE. (0,0) KOSKA LIIKE ARVOTAAN ITSE METODISSA
            for (hirvio h1 : hg.getLista()) {
                h1.siirra(0, 0);
            }

            //KOORDINAATIT
            System.out.println("pelaaja: " + p.getX() + " " + p.getY());

            //PELIKENTTÄ
            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 20; j++) {

                    for (hirvio h1 : hg.getLista()) {
                        if (h1.getX() == j && h1.getY() == i) {
                            System.out.print("H");
                        }
                    }
                    if (p.getX() == j && p.getY() == i) {
                        System.out.print("O");
                    }else if(vk.getX1() == j && vk.getY1() == i || vk.getX2() == j && vk.getY2() == i || vk.getX3() == j && vk.getY3() == i || vk.getX4() == j && vk.getY4() == i){
                        System.out.print("X");
                    }else {
                        System.out.print("-");
                    }
                }
                System.out.println("");
            }
            
            //TARKISTUS ONKO PELAAJA ELOSSA
            //(koordinaatit täytyy viedä luokkaan jotta tarkistus toimii)
            int apu1 = 0;
            for (hirvio h1 : hg.getLista()) {
                if (ku.pelaajakuollut(p.getX(), p.getY(), h1.getX(), h1.getY()) == true) {
                    apu1 = 1;
                    System.out.println("KUOLIT!");
                }
            }
            //BREAK EI TOIMI FOR-EACH-LOOPISSA
            if (apu1 == 1) {
                break;
            }
            
            //VOIMAKENTÄN NOLLAUS
            vk.nollaa();
        }
    }
}
