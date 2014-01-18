package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class kuolemaTest {
    private kuolema k;
    
    @Before
    public void setUp() {
        this.k = new kuolema();
    }

    @Test
    public void palauttaatrueJosPelaajaOsuuHirvioon() {
        assertEquals(true, k.pelaajakuollut(1, 0, 1, 0));
    }
    
    @Test
    public void palauttaafalseJosPelaajaOnElossa(){
        assertEquals(false, k.pelaajakuollut(1, 0, 1, 1));
    }
    
    @Test
    public void testejaKoordinaateista(){
        assertEquals(true, k.pelaajakuollut(0, 1, 0, 1));
        assertEquals(false, k.pelaajakuollut(5, 6, 4, 3));
    }
    
    //MYÖHEMMIN TESTIT HIRVIÖN KUOLEMALLE
}