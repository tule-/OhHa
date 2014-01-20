package logiikka;

public class voimakentta {
    private int X1;
    private int Y1;
    
    private int X2;
    private int Y2;
    
    private int X3;
    private int Y3;
    
    private int X4;
    private int Y4;
    
    public void nollaa(){
        this.X1 = 10000;
        this.Y1 = 10000;
        
        this.X2 = 10000;
        this.Y2 = 10000;
        
        this.X3 = 10000;
        this.Y3 = 10000;
        
        this.X4 = 10000;
        this.Y4 = 10000;
    }
    
    //PELAAJAN KOORDINAATIT
    public void hyokkaa(int x, int y){
        this.X1 = x + 1;
        this.Y1 = y;
        
        this.X2 = x - 1;
        this.Y2 = y;
        
        this.X3 = x;
        this.Y3 = y + 1;
        
        this.X4 = x;
        this.Y4 = y - 1;
    }
    
    
    //get KOMENNOT
    public int getX1(){
        return X1;
    }
    
    public int getY1(){
        return Y1;
    }
    
    public int getX2(){
        return X2;
    }
    
    public int getY2(){
        return Y2;
    }
    
    public int getX3(){
        return X3;
    }
    
    public int getY3(){
        return Y3;
    }
    
    public int getX4(){
        return X4;
    }
    
    public int getY4(){
        return Y4;
    }
}
