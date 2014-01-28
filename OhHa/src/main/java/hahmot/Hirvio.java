package hahmot;

import grafiikka.HirvioKuva;
import java.awt.Graphics;
import java.util.Random;
import logiikka.Hahmo;

public class Hirvio extends Hahmo {
    
    public Hirvio(){
        super(0,0);
    }
    
    @Override
    public void siirra(int dx, int dy){
        
        Random r = new Random();
        dx = r.nextInt(3) - 1;
        dy = r.nextInt(3) - 1;
        
        if(this.getX() + dx <= 775 && this.getX() + dx >= 0 && this.getY() + dy <= 575 && this.getY() + dy >= 0){
            super.siirra(dx * 25, dy * 25);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
        HirvioKuva kuva = new HirvioKuva();
        kuva.getHirvio(graphics, this.getX(), this.getY());
    }
    
}
