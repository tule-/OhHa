package kuuntelijat;

import hahmot.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;
import ohha.ohha.Kayttoliittyma;
import valikot.Ohjeet;
import valikot.Sepontarina;

/**
 * Pelin aloitus kuuntelija.
 * 
 * Voidaan valita aloitetaanko uusi peli vai
 * luetaanko Sepon tarina.
 */
public class Alkukuuntelija implements ActionListener {

    private JFrame frame;
    /**
     * Uuden pelin aloittava nappi.
     */
    private JButton uusi;
    /**
     * Sepon tarinan avaava nappi.
     */
    private JButton tarina;
    /**
     * Ohjeet valikon avaava nappi.
     */
    private JButton ohjeet;

    public Alkukuuntelija(JFrame frame, JButton uusipeli, JButton sepontarina, JButton ohjeet) {
        this.frame = frame;
        this.uusi = uusipeli;
        this.tarina = sepontarina;
        this.ohjeet = ohjeet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Kayttoliittyma k = new Kayttoliittyma(new Pelaaja(), new HirvioGeneraattori(), new Voimakentta());
        Sepontarina s = new Sepontarina();
        Ohjeet o = new Ohjeet();
        
        if (e.getSource() == uusi) {
            k.run();
            frame.dispose();
        }
        if (e.getSource() == tarina) {
            s.run();
            frame.dispose();
        }
        if(e.getSource() == ohjeet){
            o.run();
            frame.dispose();
        }
    }
}
