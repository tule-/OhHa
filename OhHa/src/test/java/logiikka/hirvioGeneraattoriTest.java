package logiikka;

import hahmot.hirvio;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class hirvioGeneraattoriTest {

    private hirvioGeneraattori hg;

    @Before
    public void setUp() {
        this.hg = new hirvioGeneraattori();
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
        ArrayList<hirvio> lista = hg.getLista();

        assertEquals(hg.getLista(), lista);
    }

    @Test
    public void luodutHirviotToimivat() {
        hirvio h = hg.getLista().get(0);
        h.siirra(0, 0);

        //X-AKSELI
        if (h.getX() <= 2 && h.getX() >= 0) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }

        //Y-AKSELI
        if (h.getY() <= 2 && h.getY() >= 0) {
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