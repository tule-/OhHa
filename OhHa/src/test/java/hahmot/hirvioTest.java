package hahmot;

import logiikka.hahmo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class hirvioTest {
    private hahmo h;
    
    @Before
    public void setUp() {
        this.h = new hirvio();
        //ALKUKOORDINAATIT (1,1)
    }

    //KAIKKIA TULEE MUUTTAA KUN super:IA MUUTETAAN
    @Test
    public void hirviollaAloitusKoordinaatit() {
        assertEquals(1, h.getX());
        assertEquals(1, h.getY());
    }
    
    @Test
    public void hirvioLiikkuuOikeinYhdenAskeleenJohonkinSuuntaan(){
        h.siirra(0, 0);
        int x = h.getX();
        int y = h.getY();
        
        //X-AKSELI
        if(x <= 2 && x >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
        
        //Y-AKSELI
        if(y <= 2 && y >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }
    
    @Test
    public void hirvioEiLiikuPelikentanUlkopuolelle(){
        for (int i = 0; i < 1000; i++) {
            h.siirra(i, i);
        }
        
        //X-AKSELI
        if(h.getX() <= 19 && h.getX() >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
        
        //Y-AKSELI
        if(h.getY() <= 9 && h.getY() >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }
    
    //LISÄTÄÄN TESTEJÄ GRAAFISELLELIITTYMÄLLE
    @Test
    public void piirraMetodi(){
        h.piirra(null);
    }
}