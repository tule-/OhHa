package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class kuolemaTest {
    private kuolema k;
    private voimakentta vk;
    
    @Before
    public void setUp() {
        this.k = new kuolema();
        this.vk = new voimakentta();
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
    
    @Test
    public void palauttaatrueJosHirvioKuolee(){
        vk.hyokkaa(5, 5);
        
        assertEquals(true, k.hirviokuollut(6, 5, vk));
        assertEquals(true, k.hirviokuollut(4, 5, vk));
        assertEquals(true, k.hirviokuollut(5, 6, vk));
        assertEquals(true, k.hirviokuollut(5, 4, vk));
    }
    
    @Test
    public void palauttaafalseJosHirvioOnElossa(){
        vk.hyokkaa(5, 5);
        
        assertEquals(false, k.hirviokuollut(3, 5, vk));
        assertEquals(false, k.hirviokuollut(5, 5, vk));
        assertEquals(false, k.hirviokuollut(5, 3, vk));
        assertEquals(false, k.hirviokuollut(5, 7, vk));
        assertEquals(false, k.hirviokuollut(1, 0, vk));
    }
}