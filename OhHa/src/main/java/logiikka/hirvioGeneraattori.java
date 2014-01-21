package logiikka;

import hahmot.hirvio;
import java.util.ArrayList;

public class hirvioGeneraattori {

    private ArrayList<hirvio> hirviot;

    public hirvioGeneraattori() {
        this.hirviot = new ArrayList<>();
    }

    public ArrayList<hirvio> lisaa(int maara) {
        for (int i = 0; i <= maara; i++) {
            hirviot.add(new hirvio());
        }
        return hirviot;
    }
    
    public ArrayList<hirvio> getLista(){
        return hirviot;
    }
    
    public void tapaHirvio(int i){
        hirviot.remove(i);
    }
    
    //GENERAATTORIIN LISÄTÄÄN OMINAISUUS VALITA HIRVIÖN SPAWNAAMISPAIKKA
}
