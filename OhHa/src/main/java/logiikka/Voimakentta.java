package logiikka;

import grafiikka.VoimakenttaKuva;
import java.awt.Graphics;

/**
 * Voimakenttä luokka määrää voimakentän
 * toiminnan pelikentällä.
 * 
 * Voimakenttä on joko pelikentän ulkopuolella
 * tai pelaajan ympärillä.
 * 
 * Voimakenttä on aluksi pelikentän ulkopuolella.
 */
public class Voimakentta {
    private int X1 = 10000;
    private int Y1 = 10000;
    private int X2 = 10000;
    private int Y2 = 10000;
    private int X3 = 10000;
    private int Y3 = 10000;
    private int X4 = 10000;
    private int Y4 = 10000;

    /**
     * Metodi nollaa voimakentän eli asettaa sen arvot pelikentän pelikentän
     * ulkopuolelle.
     */
    public void nollaa() {
        this.X1 = 10000;
        this.Y1 = 10000;

        this.X2 = 10000;
        this.Y2 = 10000;

        this.X3 = 10000;
        this.Y3 = 10000;

        this.X4 = 10000;
        this.Y4 = 10000;
    }

    /**
     * Metodi asettaa voimakentän pelikentälle.
     * 
     * Parametreinä se saa pelaajan koordinaatit ja se vaikuttaa 
     * pelaajasta yhden koordinaatin verran ylös, alas, vasemmalle ja oikealle.
     * 
     * @param x pelaajan x-koordinaatti
     * 
     * @param y pelaajan y-koordinaatti
     */
    public void hyokkaa(int x, int y) {
        this.X1 = x + 25;
        this.Y1 = y;

        this.X2 = x - 25;
        this.Y2 = y;

        this.X3 = x;
        this.Y3 = y + 25;

        this.X4 = x;
        this.Y4 = y - 25;
    }

    public int getX1() {
        return X1;
    }

    public int getY1() {
        return Y1;
    }

    public int getX2() {
        return X2;
    }

    public int getY2() {
        return Y2;
    }

    public int getX3() {
        return X3;
    }

    public int getY3() {
        return Y3;
    }

    public int getX4() {
        return X4;
    }

    public int getY4() {
        return Y4;
    }

    /**
     * Piirtää voimakentän pelikentälle.
     * 
     * @param graphics 
     */
    public void piirra(Graphics graphics) {
        VoimakenttaKuva kuva = new VoimakenttaKuva();

        kuva.getVoimakentta(graphics, X1, Y1);
        kuva.getVoimakentta(graphics, X2, Y2);
        kuva.getVoimakentta(graphics, X3, Y3);
        kuva.getVoimakentta(graphics, X4, Y4);
    }
}
