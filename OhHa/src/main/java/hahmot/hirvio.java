package hahmot;

import java.awt.Graphics;
import java.util.Random;
import logiikka.hahmo;

public class hirvio extends hahmo {
    
    public hirvio(){
        super(1,1);
    }
    
    @Override
    public void siirra(int dx, int dy){
        
        Random r = new Random();
        dx = r.nextInt(3) - 1;
        dy = r.nextInt(3) - 1;
        
        if(this.getX() + dx <= 19 && this.getX() + dx >= 0 && this.getY() + dy <= 9 && this.getY() + dy >= 0){
            super.siirra(dx, dy);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
