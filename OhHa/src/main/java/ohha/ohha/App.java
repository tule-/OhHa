package ohha.ohha;

import hahmot.Pelaaja;
import javax.swing.SwingUtilities;
import logiikka.HirvioGeneraattori;
import logiikka.Voimakentta;
import valikot.Uusipeli;

public class App {

    public static void main(String[] args) {
        
        //Kayttoliittyma k = new Kayttoliittyma(new Pelaaja(), new HirvioGeneraattori(), new Voimakentta());
        Uusipeli u = new Uusipeli();
        SwingUtilities.invokeLater(u);
    }
}
