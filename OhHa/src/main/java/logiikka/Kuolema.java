package logiikka;

/**
 * Kuolema luokka tarkistaa onko hirviö tai pelaaja kuollut.
 *
 * Kuolema tarkistaa koordinaattien avulla osuuko pelaaja hirviöön tai hirviö
 * voimakenttään.
 */
public class Kuolema {

    /**
     * Tarkistaa onko pelaaja kuollut.
     *
     * Tarkistus tapahtuu niin, että katsotaan ovatko hirviön ja pelaajan
     * koordinaatit samat.
     *
     * @param px pelaajan x-koordinaatti
     * @param py pelaajan y-koordinaatti
     *
     * @param hx hirviön x-koordinaatti
     * @param hy hirviön y-koordinaatti
     *
     * @return true jos pelaaja on kuollut tai false jos pelaaja on elossa
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
     * Tarkistus tapahtuu niin, että katsotaan ovatko hirviön ja voimakentän
     * koordinaatit samat.
     *
     * @param hx hirviön x-koordinaatti
     * @param hy hirviön y-koordinaatti
     *
     * @param v voimakenttä. Voidaan tuoda voimakentän koordinaatit.
     *
     * @return true jos hirviö kuolee ja false jos hirviö on elossa
     */
    public boolean hirviokuollut(int hx, int hy, Voimakentta v) {

        int x1 = v.getVoimakentta().get(0);
        int y1 = v.getVoimakentta().get(1);

        int x2 = v.getVoimakentta().get(2);
        int y2 = v.getVoimakentta().get(3);

        int x3 = v.getVoimakentta().get(4);
        int y3 = v.getVoimakentta().get(5);

        int x4 = v.getVoimakentta().get(6);
        int y4 = v.getVoimakentta().get(7);

        if (hx == x1 && hy == y1 || hx == x2 && hy == y2 || hx == x3 && hy == y3 || hx == x4 && hy == y4) {
            return true;
        } else {
            return false;
        }
    }
}
