package logiikka;

import hahmot.Hirvio;
import java.util.ArrayList;

public class HirvioGeneraattori {

    private ArrayList<Hirvio> hirviot;

    public HirvioGeneraattori() {
        this.hirviot = new ArrayList<>();
    }

    public ArrayList<Hirvio> lisaa(int maara) {
        for (int i = 0; i <= maara; i++) {
            hirviot.add(new Hirvio());
        }
        return hirviot;
    }
    
    public ArrayList<Hirvio> getLista(){
        return hirviot;
    }
    
    public void tapaHirvio(int i){
        hirviot.remove(i);
    }
    
    //GENERAATTORIIN LISÄTÄÄN OMINAISUUS VALITA HIRVIÖN SPAWNAAMISPAIKKA
}
