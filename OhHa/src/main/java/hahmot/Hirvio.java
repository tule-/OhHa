package hahmot;

import grafiikka.HirvioKuva;
import java.awt.Graphics;
import java.util.Random;
import logiikka.Hahmo;

/**
 * Luokka luo hirviön. Hirviö voi liikkua ja
 * se voidaan piirtää.
 * 
 * Luokka määrittelee neljä erilaista
 * hirviötä. Hirviöillä on eri aloitus
 * koordinaatit.
 * 
 * Luokka perii luokan hahmo ominaisuudet.
 */
public class Hirvio extends Hahmo {
    /**
     * 1. hirviön aloituskoordinaatit.
     */
    public Hirvio() {
        super(0, 300);
    }

    /**
     * 2. hirviön aloituskoordinaatit.
     * 
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(int x) {
        super(775, 300);
    }

    /**
     * 3. hirviön aloituskoordinaatit
     * 
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(String x) {
        super(400, 0);
    }

    /**
     * 4. hirviön aloituskoordinaatit
     * 
     * @param x käytetään tunnistamaan ko. hirviö
     */
    public Hirvio(double x) {
        super(400, 575);
    }

    
    /**
     * Siirtää hirviön haluttun paikkaan pelikentän rajojen sisällä.
     *
     * @param dx x-akelin muutos
     *
     * @param dy y-akelin muutos
     */
    @Override
    public void siirra(int dx, int dy) {

        Random r = new Random();
        int x = r.nextInt(3) - 1;
        int y = r.nextInt(3) - 1;

        if (this.getX() + x <= 775 && this.getX() + x >= 0 && this.getY() + y <= 575 && this.getY() + y >= 0) {
            super.siirra(x * 25, y * 25);
        }
    }

    /**
     * Piirtää hirviön pelikentälle.
     *
     * @param graphics
     */
    @Override
    public void piirra(Graphics graphics) {
        HirvioKuva kuva = new HirvioKuva();
        kuva.getHirvio(graphics, this.getX(), this.getY());
    }
}
