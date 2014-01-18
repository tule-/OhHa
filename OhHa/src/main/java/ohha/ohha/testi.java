package ohha.ohha;

import hahmot.hirvio;
import hahmot.pelaaja;
import java.util.Scanner;
import logiikka.hahmo;

public class testi {

    private hahmo p;
    private hahmo h;
    private Scanner l;

    public testi() {
        this.p = new pelaaja();
        this.h = new hirvio();
        this.l = new Scanner(System.in);
    }

    public void run() {
        
        //PELIKENTTÄ
        while (true) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if (p.getX() == j && p.getY() == i) {
                        System.out.print("O");
                    }else if (h.getX() == j && h.getY() == i){
                        System.out.print("H");
                    }else{
                        System.out.print("-");
                    }
                }
                System.out.println("");
            }
            
            //PELAAJAN LIIKE
            String k = l.nextLine();
            if(k.equals("d")){
                p.siirra(1, 0);
            }
            if(k.equals("s")){
                p.siirra(0, 1);
            }
            if(k.equals("a")){
                p.siirra(-1, 0);
            }
            if(k.equals("w")){
                p.siirra(0, -1);
            }
            if(k.equals("x")){
                break;
            }
            
            //HIRVIÖN LIIKE. (0,0) KOSKA LIIKE ARVOTAAN ITSE METODISSA
            h.siirra(0, 0);
            
            //KOORDINAATIT
            System.out.println("pelaaja: " +  p.getX() + " " + p.getY());
            System.out.println("hirvio: " +  h.getX() + " " + h.getY());
        }
    }
}