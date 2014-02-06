package logiikka;

/**
 * Kuolema luokka tarkistaa onko hirviö tai
 * pelaaja kuollut.
 * 
 * Kuolema tarkistaa koordinaattien avulla
 * osuuko pelaaja hirviöön tai hirviö
 * voimakenttään.
 */
public class Kuolema {

    /**
     * Tarkistaa onko pelaaja kuollut. 
     * 
     * Tarkistus tapahtuu niin, että katsotaan ovatko
     * hirviön ja pelaajan koordinaatit samat.
     * 
     * @param px pelaajan x-koordinaatti
     * @param py pelaajan y-koordinaatti
     * 
     * @param hx hirviön x-koordinaatti
     * @param hy hirviön y-koordinaatti
     * 
     * @return true jos pelaaja on kuollut tai false jos
     * pelaaja on elossa
     */
    public boolean pelaajakuollut(int px, int py, int hx, int hy) {
        if (px == hx && py == hy) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistus onko hirviö kuollut. 
     * 
     * Tarkistus tapahtuu niin, että katsotaan ovatko 
     * hirviön ja voimakentän koordinaatit samat.
     * 
     * @param hx hirviön x-koordinaatti
     * @param hy hirviön y-koordinaatti
     * 
     * @param v voimakenttä. Voidaan tuoda voimakentän
     * koordinaatit.
     * 
     * @return true jos hirviö kuolee ja false jos hirviö on
     * elossa
     */
    public boolean hirviokuollut(int hx, int hy, Voimakentta v) {
        if (hx == v.getX1() && hy == v.getY1() || hx == v.getX2() && hy == v.getY2() || hx == v.getX3() && hy == v.getY3() || hx == v.getX4() && hy == v.getY4()) {
            return true;
        } else {
            return false;
        }
    }
}
