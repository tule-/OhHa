package logiikka;

public class Pistelaskuri {
    private int pisteet;
    
    public Pistelaskuri(){
        this.pisteet = 0;
    }
    
    public void lisaa(){
        this.pisteet += 10;
    }
    
    public int getPisteet(){
        return pisteet;
    }
}
