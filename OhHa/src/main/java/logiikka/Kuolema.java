package logiikka;

public class Kuolema {

    public boolean pelaajakuollut(int px, int py, int hx, int hy) {
        if (px == hx && py == hy) {
            //GRAAFISESSA LIITTYMÄSSÄ SIIRRYTÄÄN LOPPURUUTUUN
            return true;
        } else {
            return false;
        }
    }

    public boolean hirviokuollut(int hx, int hy, Voimakentta v) {
        if (hx == v.getX1() && hy == v.getY1() || hx == v.getX2() && hy == v.getY2() || hx == v.getX3() && hy == v.getY3() || hx == v.getX4() && hy == v.getY4()) {
            return true;
        } else {
            return false;
        }
    }
}
