package grafiikka;

import java.awt.Color;
import java.awt.Graphics;

public class LuolanSuuaukko {
    
    public void getLuolanSuuaukko(Graphics graphics){
        graphics.setColor(Color.LIGHT_GRAY);
        
        graphics.fillOval(-12, 300, 25, 25);
        graphics.fillOval(787, 300, 25, 25);
        graphics.fillOval(400, -12, 25, 25);
        graphics.fillOval(400, 587, 25, 25);
    }
}
