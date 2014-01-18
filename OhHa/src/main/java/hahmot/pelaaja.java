package hahmot;

import java.awt.Graphics;
import logiikka.hahmo;

public class pelaaja extends hahmo {
    
    public pelaaja(){
        super(10,5);
    }
    
    @Override
    public void siirra(int dx, int dy){
        //graafisessa liittymässä numerot korvataan pelikentän dimensioilla
        if(this.getX() + dx <= 19 && this.getX() + dx >= 0 && this.getY() + dy <= 9 && this.getY() + dy >= 0){
            super.siirra(dx, dy);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
    }
}
