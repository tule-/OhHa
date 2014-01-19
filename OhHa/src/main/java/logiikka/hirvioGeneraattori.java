package logiikka;

import hahmot.hirvio;
import java.util.ArrayList;

public class hirvioGeneraattori {

    private ArrayList<hahmo> hirviot;
    private hahmo h;

    public hirvioGeneraattori() {
        this.hirviot = new ArrayList<>();
        this.h = new hirvio();
    }

    public ArrayList<hahmo> lisaa(int maara) {
        for (int i = 0; i < maara; i++) {
            hirviot.add(h);
        }
        return hirviot;
    }
    
    public ArrayList<hahmo> getLista(){
        return hirviot;
    }
}
