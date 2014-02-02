package hahmot;

import grafiikka.HirvioKuva;
import java.awt.Graphics;
import java.util.Random;
import logiikka.Hahmo;

public class Hirvio extends Hahmo {
    
    public Hirvio(){
        super(0,300);
    }
    
    public Hirvio(int x){
        super(775,300);
    }
    
    public Hirvio(String x){
        super(400,0);
    }
    
    public Hirvio(double x){
        super(400,575);
    }
    
    @Override
    public void siirra(int dx, int dy){
        
        Random r = new Random();
        int x = r.nextInt(3) - 1;
        int y = r.nextInt(3) - 1;
        
        if(this.getX() + x <= 775 && this.getX() + x >= 0 && this.getY() + y <= 575 && this.getY() + y >= 0){
            super.siirra(x * 25, y * 25);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
        HirvioKuva kuva = new HirvioKuva();
        kuva.getHirvio(graphics, this.getX(), this.getY());
    }
    
}
