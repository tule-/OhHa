package logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoimakenttaTest {
    private Voimakentta vk;

    @Before
    public void setUp() {
        this.vk = new Voimakentta();
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
        vk.hyokkaa(25, 25);
        
        assertEquals(50, vk.getX1());
        assertEquals(25, vk.getY1());
        
        assertEquals(0, vk.getX2());
        assertEquals(25, vk.getY2());
        
        assertEquals(25, vk.getX3());
        assertEquals(50, vk.getY3());
        
        assertEquals(25, vk.getX4());
        assertEquals(0, vk.getY4());
    }
    
    @Test
    public void nollaaKomentoAsettaaKoordinaatitOutOfBounds(){
        vk.hyokkaa(25, 25);
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
        vk.hyokkaa(25, 25);
        assertEquals(50, vk.getX1());
    }
    
    @Test
    public void palautetaanY1(){
        vk.hyokkaa(25, 25);
        assertEquals(25, vk.getY1());
    }
    
    @Test
    public void palautetaanX2(){
        vk.hyokkaa(25, 25);
        assertEquals(0, vk.getX2());
    }
    
    @Test
    public void palautetaanY2(){
        vk.hyokkaa(25, 25);
        assertEquals(25, vk.getY2());
    }
    
    @Test
    public void palautetaanX3(){
        vk.hyokkaa(25, 25);
        assertEquals(25, vk.getX3());
    }
    
    @Test
    public void palautetaanY3(){
        vk.hyokkaa(25, 25);
        assertEquals(50, vk.getY3());
    }
    
    @Test
    public void palautetaanX4(){
        vk.hyokkaa(25, 25);
        assertEquals(25, vk.getX4());
    }
    
    @Test
    public void palautetaanY4(){
        vk.hyokkaa(25, 25);
        assertEquals(0, vk.getY4());
    }
}