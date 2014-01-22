package logiikka;

public class pistelaskuri {
    private int pisteet;
    
    public pistelaskuri(){
        this.pisteet = 0;
    }
    
    public void lisaa(){
        this.pisteet += 10;
    }
    
    public int getPisteet(){
        return pisteet;
    }
}
