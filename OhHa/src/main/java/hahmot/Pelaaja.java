package hahmot;

import grafiikka.PelaajaKuva;
import java.awt.Graphics;
import logiikka.Hahmo;

public class Pelaaja extends Hahmo {

    public Pelaaja() {
        super(400, 300);
    }

    @Override
    public void siirra(int dx, int dy) {
        if (this.getX() + dx <= 775 && this.getX() + dx >= 0 && this.getY() + dy <= 575 && this.getY() + dy >= 0) {
            super.siirra(dx, dy);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
        PelaajaKuva kuva = new PelaajaKuva();
        kuva.getPelaaja(graphics, this.getX(), this.getY());
    }
}
