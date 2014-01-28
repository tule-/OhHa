package ohha.ohha;

import hahmot.Hirvio;
import hahmot.Pelaaja;
import java.util.Scanner;
import logiikka.Hahmo;
import logiikka.HirvioGeneraattori;
import logiikka.Kuolema;
import logiikka.Pistelaskuri;
import logiikka.Voimakentta;

public class testi {

    private Hahmo p;
    public HirvioGeneraattori hg;

    public testi() {
        this.p = new Pelaaja();
        this.hg = new HirvioGeneraattori();
    }

    public void run() {
        Scanner l = new Scanner(System.in);
        Kuolema ku = new Kuolema();
        Voimakentta vk = new Voimakentta();
        Pistelaskuri pl = new Pistelaskuri();
        int apu2 = 5;

        //HIRVIÖIDEN LKM (+1)
        hg.lisaa(2);

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
            for (Hirvio h1 : hg.getLista()) {
                h1.siirra(0, 0);
            }
            
            //PISTEET
            System.out.println("pelaajan pisteet: " + pl.getPisteet());
            
            //KIERROSLASKURI
            System.out.println("uusi hirviö: " + apu2);

            //KOORDINAATIT
            System.out.println("pelaaja: " + p.getX() + " " + p.getY());
            
            //HIRVIÖIDEN LKM
            System.out.println("hirviöitä: " + hg.getLista().size());

            //PELIKENTTÄ
            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 20; j++) {

                    for (Hirvio h1 : hg.getLista()) {
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
            for (Hirvio h1 : hg.getLista()) {
                if (ku.pelaajakuollut(p.getX(), p.getY(), h1.getX(), h1.getY()) == true) {
                    apu1 = 1;
                    System.out.println("KUOLIT!");
                    System.out.println("Pisteesi: " + pl.getPisteet());
                }
            }
            
            //TARKISTUS ONKO HIRVIO KUOLLUT
            //(tarvitaan hirvion koordinaatit sekä voimakentta)
            for (int i = 0; i < hg.getLista().size(); i++) {
                if(ku.hirviokuollut(hg.getLista().get(i).getX(), hg.getLista().get(i).getY(), vk) ==  true){
                    hg.tapaHirvio(i);
                    System.out.println("Hirvio kuoli!");
                    pl.lisaa();
                }
            }
            
            //BREAK EI TOIMI FOR-EACH-LOOPISSA
            if (apu1 == 1) {
                break;
            }
            
            if(hg.getLista().isEmpty()){
                System.out.println("VOITIT PELIN!");
                break;
            }
            
            //VOIMAKENTÄN NOLLAUS
            vk.nollaa();
            
            //JOKA VIIDEN KIERROS LISÄTÄÄN HIRVIÖ
            apu2--;
            if(apu2 == 0){
                hg.lisaa(0);
                apu2 = 5;
            }
        }
    }
}
