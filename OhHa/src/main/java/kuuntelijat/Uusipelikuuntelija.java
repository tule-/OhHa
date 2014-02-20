package kuuntelijat;

import hahmot.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;
import ohha.ohha.Kayttoliittyma;

/**
 * Kuuntelija joka aloittaa uuden pelin.
 * 
 * Uusipelikuuntelija toimii Sepontarina -
 * sekä Peliloppu- ruuduissa.
 */
public class Uusipelikuuntelija implements ActionListener{
    
    private JFrame frame;
    /**
     * Uuden pelin aloittava nappi.
     */
    private JButton uusi;
    
    public Uusipelikuuntelija(JFrame frame, JButton uusipeli){
        this.frame = frame;
        this.uusi = uusipeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Kayttoliittyma k = new Kayttoliittyma(new Pelaaja(), new HirvioGeneraattori(), new Voimakentta());
        if(e.getSource() == uusi){
            k.run();
            frame.dispose();
        }
    }
}
