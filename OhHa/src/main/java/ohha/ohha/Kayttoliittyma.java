package ohha.ohha;

import grafiikka.Pelikentta;
import hahmot.Pelaaja;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import logiikka.HirvioGeneraattori;
import kuuntelijat.Pelikuuntelija;
import logiikka.Voimakentta;

/**
 * Vastaa pelikentän, pelaajan, hirviögeneraattorin ja voimakentän
 * lisäämisen sekä alustaa kuuntelijat.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelaaja p;
    private HirvioGeneraattori hg;
    private Voimakentta vk;
    /**
     * Inforuutu pelikentän alalaitaan.
     */
    private JLabel info;

    /**
     * Alustaa pelaajan, hirviögeneraattorin ja voimakentän.
     * 
     * Lisää myös inforuudulle pelin aloitusviestin.
     * 
     * @param p pelaaja
     * @param hg hirviögeneraattori
     * @param vk voimakenttä
     */
    public Kayttoliittyma(Pelaaja p, HirvioGeneraattori hg, Voimakentta vk) {
        this.p = p;
        this.hg = hg;
        this.vk = vk;

        this.info = new JLabel("Peli alkoi!");
    }

    /**
     * Rakentaa pelin ja näyttää sen.
     * 
     * Määrätään myös pelikentän paikan näytöllä.
     */
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

    /**
     * Luo komponentit.
     * 
     * Sisältää pelikentän sekä inforuudun.
     * 
     * @param container 
     */
    public void luoKomponentit(Container container) {
        Pelikentta pk = new Pelikentta(p, hg, vk);
        container.add(pk);
        container.add(info, BorderLayout.SOUTH);
    }

    /**
     * Lisää Pelikuuntelijan.
     * 
     * Pelikuuntelija pyörittää peliä.
     */
    public void lisaaKuuntelija() {
        frame.addKeyListener(new Pelikuuntelija(frame, p, hg, vk, info));
    }

    public JFrame getFrame() {
        return frame;
    }
}
