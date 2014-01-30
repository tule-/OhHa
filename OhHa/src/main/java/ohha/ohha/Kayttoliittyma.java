package ohha.ohha;

import grafiikka.Pelikentta;
import hahmot.Pelaaja;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import logiikka.HirvioGeneraattori;
import kuuntelijat.Pelikuuntelija;
import logiikka.Voimakentta;

public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    
    private Pelaaja p;
    private HirvioGeneraattori hg;
    
    private Voimakentta vk;
    
    public Kayttoliittyma(Pelaaja p, HirvioGeneraattori hg, Voimakentta vk){
        this.p = p;
        this.hg = hg;
        
        this.vk = vk;
    }

    @Override
    public void run() {
        frame = new JFrame();
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 4, screenSize.height / 4);
        
        luoKomponentit(frame.getContentPane());
        
        lisaaKuuntelija();
        
        //ALUSTETAAN HIRVIO
        hg.lisaa(0);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        Pelikentta pk = new Pelikentta(p, hg, vk);
        container.add(pk);
    }
    
    public void lisaaKuuntelija(){
        frame.addKeyListener(new Pelikuuntelija(frame, p, hg, vk));
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
