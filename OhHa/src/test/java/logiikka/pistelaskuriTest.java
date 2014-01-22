package logiikka;

import logiikka.pistelaskuri;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class pistelaskuriTest {
    private pistelaskuri pl;

    @Before
    public void setUp() {
        this.pl = new pistelaskuri();
    }

    @Test
    public void pistelaskurinArvoAlussaNolla() {
        assertEquals(0, pl.getPisteet());
    }
    
    @Test
    public void pisteetLisääntuu10kerrallaan(){
        pl.lisaa();
        assertEquals(10, pl.getPisteet());
    }
    
    @Test
    public void voidaanLisataPisteitaMontaKertaa(){
        for (int i = 0; i < 10; i++) {
            pl.lisaa();
        }
        
        assertEquals(100, pl.getPisteet());
    }
}