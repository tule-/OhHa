package logiikka;

import logiikka.voimakentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class voimakenttaTest {
    private voimakentta vk;

    @Before
    public void setUp() {
        this.vk = new voimakentta();
    }

    @Test
    public void voimakentanKoordinaatitAluksiOutOfBounds() {
        assertEquals(10000, vk.getX1());
        assertEquals(10000, vk.getY1());
        
        assertEquals(10000, vk.getX2());
        assertEquals(10000, vk.getY2());
        
        assertEquals(10000, vk.getX3());
        assertEquals(10000, vk.getY3());
        
        assertEquals(10000, vk.getX4());
        assertEquals(10000, vk.getY4());
    }
    
    @Test
    public void hyokkaaKomentotoimii(){
        vk.hyokkaa(5, 5);
        
        assertEquals(6, vk.getX1());
        assertEquals(5, vk.getY1());
        
        assertEquals(4, vk.getX2());
        assertEquals(5, vk.getY2());
        
        assertEquals(5, vk.getX3());
        assertEquals(6, vk.getY3());
        
        assertEquals(5, vk.getX4());
        assertEquals(4, vk.getY4());
    }
    
    @Test
    public void nollaaKomentoAsettaaKoordinaatitOutOfBounds(){
        vk.hyokkaa(5, 5);
        vk.nollaa();
        
        assertEquals(10000, vk.getX1());
        assertEquals(10000, vk.getY1());
        
        assertEquals(10000, vk.getX2());
        assertEquals(10000, vk.getY2());
        
        assertEquals(10000, vk.getX3());
        assertEquals(10000, vk.getY3());
        
        assertEquals(10000, vk.getX4());
        assertEquals(10000, vk.getY4());
    }
    
    //get KOMENNOT
    @Test
    public void palautetaanX1(){
        vk.hyokkaa(5, 5);
        assertEquals(6, vk.getX1());
    }
    
    @Test
    public void palautetaanY1(){
        vk.hyokkaa(5, 5);
        assertEquals(5, vk.getY1());
    }
    
    @Test
    public void palautetaanX2(){
        vk.hyokkaa(5, 5);
        assertEquals(4, vk.getX2());
    }
    
    @Test
    public void palautetaanY2(){
        vk.hyokkaa(5, 5);
        assertEquals(5, vk.getY2());
    }
    
    @Test
    public void palautetaanX3(){
        vk.hyokkaa(5, 5);
        assertEquals(5, vk.getX3());
    }
    
    @Test
    public void palautetaanY3(){
        vk.hyokkaa(5, 5);
        assertEquals(6, vk.getY3());
    }
    
    @Test
    public void palautetaanX4(){
        vk.hyokkaa(5, 5);
        assertEquals(5, vk.getX4());
    }
    
    @Test
    public void palautetaanY4(){
        vk.hyokkaa(5, 5);
        assertEquals(4, vk.getY4());
    }
}