package kuuntelijat;

import hahmot.Pelaaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;
import ohha.ohha.Kayttoliittyma;
import valikot.Sepontarina;

/**
 * Pelin aloitus kuuntelija.
 * 
 * Voidaan valita aloitetaanko uusi peli vai
 * luetaanko Sepon tarina.
 */
public class Alkukuuntelija implements ActionListener {

    private JFrame frame;
    private JButton uusi;
    private JButton tarina;

    public Alkukuuntelija(JFrame frame, JButton uusipeli, JButton tarina) {
        this.frame = frame;
        this.uusi = uusipeli;
        this.tarina = tarina;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Kayttoliittyma k = new Kayttoliittyma(new Pelaaja(), new HirvioGeneraattori(), new Voimakentta());
        Sepontarina s = new Sepontarina();
        
        if (e.getSource() == uusi) {
            k.run();
            frame.dispose();
        }
        if (e.getSource() == tarina) {
            s.run();
            frame.dispose();
        }
    }
}
