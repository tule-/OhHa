package logiikka;

import hahmot.hirvio;
import hahmot.pelaaja;

public class kuolema {

    private pelaaja p;
    private hirvio h;

    public kuolema() {
        this.p = new pelaaja();
        this.h = new hirvio();
    }

    public boolean pelaajakuollut(int px, int py, int hx, int hy) {
        if (px == hx && py == hy) {
            //GRAAFISESSA LIITTYMÄSSÄ SIIRRYTÄÄN LOPPURUUTUUN
            System.out.println("KUOLIT!");
            return true;
        } else {
            return false;
        }
    }
    
    //LISÄTÄÄN MYÖHEMMIN HIRVIÖN KUOLEMA
}
