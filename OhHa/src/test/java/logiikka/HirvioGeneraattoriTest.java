package logiikka;

import hahmot.Hirvio;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HirvioGeneraattoriTest {

    private HirvioGeneraattori hg;

    @Before
    public void setUp() {
        this.hg = new HirvioGeneraattori();
        hg.lisaa(0);
    }

    @Test
    public void generaattoriLuoHirvion() {
        assertEquals(1, hg.getLista().size());
    }

    @Test
    public void generaattoriLuoMontaHirviota() {
        hg.lisaa(98);

        assertEquals(100, hg.getLista().size());
    }

    @Test
    public void metodigetListaPalauttaaListan() {
        ArrayList<Hirvio> lista = hg.getLista();

        assertEquals(hg.getLista(), lista);
    }

    @Test
    public void luodutHirviotToimivat() {
        Hirvio h = hg.getLista().get(0);
        h.siirra(0, 0);

        //X-AKSELI
        if (h.getX() <= 25 && h.getX() >= 0) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }

        //Y-AKSELI
        if (h.getY() <= 25 && h.getY() >= 0) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
    }

    @Test
    public void lisaaMetodiPalauttaaListan() {
        assertEquals(hg.lisaa(0), hg.getLista());
    }
    
    @Test
    public void komentotapaHirvioPoistaaHirvionListalta(){
        hg.lisaa(2); // 1 + 3 HIRVIÖTÄ
        hg.tapaHirvio(1);
        
        assertEquals(3, hg.getLista().size());
    }
}