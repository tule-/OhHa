package hahmot;

import logiikka.hahmo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class pelaajaTest {
    private hahmo p;

    @Before
    public void setUp() {
        this.p = new pelaaja();
        //ALKU KOORDINAATIT (10,5)
    }

    
    //TULEE MUUTTAA KUN super:IA MUUTETAAN
    @Test
    public void pelaajallaAloitusKoordinaatit() {
        assertEquals(10, p.getX());
        assertEquals(5, p.getY());
    }
    
    @Test
    public void pelaajaLiikkuuOikein(){
        p.siirra(1, 1);
        
        assertEquals(11, p.getX());
        assertEquals(6, p.getY());
    }
    
    
    //TULEE MUUTTAA KUN PELIKENTÄN SUURUUS MUUTTUU
    @Test
    public void pelaajaPysyyPelikentanSisalla(){
        p.siirra(1000, 0);
        p.siirra(0, 1000);
        p.siirra(-1000, 0);
        p.siirra(0, -1000);
        
        assertEquals(10, p.getX());
        assertEquals(5, p.getY());
    }
    
    //LISÄÄ TESTEJÄ KUN GRAFIIKKALIITTYMÄ SAADAAN KASAAN
    @Test
    public void piirraMetodi(){
        p.piirra(null);
    }
}