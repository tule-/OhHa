package ohha.ohha;

import hahmot.pelaaja;
import java.util.Scanner;
import logiikka.hahmo;

public class testi {

    private hahmo p;
    private Scanner l;

    public testi() {
        this.p = new pelaaja();
        this.l = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if (p.getX() == j && p.getY() == i) {
                        System.out.print("O");
                    }else{
                        System.out.print("-");
                    }
                }
                System.out.println("");
            }
            
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
        }
    }
}
