package hahmot;

import logiikka.Hahmo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Hahmo p;

    @Before
    public void setUp() {
        this.p = new Pelaaja();
        //ALKU KOORDINAATIT (400,300)
    }

    @Test
    public void pelaajallaAloitusKoordinaatit() {
        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }

    @Test
    public void pelaajaLiikkuuOikein() {
        p.siirra(25, 25);

        assertEquals(425, p.getX());
        assertEquals(325, p.getY());
    }

    @Test
    public void pelaajaPysyyPelikentanSisalla() {
        p.siirra(1000, 0);
        p.siirra(0, 1000);

        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }

    @Test
    public void pelaajaPysyyPelikentanSisalla2() {
        p.siirra(-1000, 0);
        p.siirra(0, -1000);

        assertEquals(400, p.getX());
        assertEquals(300, p.getY());
    }

    //LISÄÄ TESTEJÄ KUN GRAFIIKKALIITTYMÄ SAADAAN KASAAN?
}