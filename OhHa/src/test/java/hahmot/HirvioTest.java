package hahmot;

import logiikka.Hahmo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HirvioTest {
    private Hahmo h;
    
    @Before
    public void setUp() {
        this.h = new Hirvio();
        //ALKUKOORDINAATIT (0,0)
    }

    @Test
    public void hirviollaAloitusKoordinaatit() {
        assertEquals(0, h.getX());
        assertEquals(0, h.getY());
    }
    
    @Test
    public void hirvioLiikkuuOikeinYhdenAskeleenJohonkinSuuntaan(){
        h.siirra(0, 0);
        int x = h.getX();
        int y = h.getY();
        
        //X-AKSELI
        if(x <= 25 && x >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
        
        //Y-AKSELI
        if(y <= 25 && y >= 0){
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
        if(h.getX() <= 800 && h.getX() >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
        
        //Y-AKSELI
        if(h.getY() <= 600 && h.getY() >= 0){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }
    
    //LISÄTÄÄN TESTEJÄ GRAAFISELLELIITTYMÄLLE?
}