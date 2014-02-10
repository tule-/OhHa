package ohha.ohha;

import grafiikka.Pelikentta;
import hahmot.Pelaaja;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import logiikka.HirvioGeneraattori;
import kuuntelijat.Pelikuuntelija;
import logiikka.Voimakentta;

/**
 * Vastaa pelikentän, pelaajan, hirviögeneraattorin ja voimakentän lisäämisen
 * sekä alustaa kuuntelijat.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelaaja p;
    private HirvioGeneraattori hg;
    private Voimakentta vk;
    /**
     * Inforuutu pelikentän ylälaitaan.
     */
    private JLabel info;
    private JLabel info2;

    /**
     * Alustaa pelaajan, hirviögeneraattorin ja voimakentän.
     *
     * Lisää myös inforuuduille värin ja aloitusviestin.
     *
     * @param p pelaaja
     * @param hg hirviögeneraattori
     * @param vk voimakenttä
     */
    public Kayttoliittyma(Pelaaja p, HirvioGeneraattori hg, Voimakentta vk) {
        this.p = p;
        this.hg = hg;
        this.vk = vk;
        /**
         * Ensimmäinen inforuutu ja sen väri.
         */
        this.info = new JLabel("Peli alkoi!");
        info.setBackground(Color.BLACK);
        info.setForeground(Color.GRAY);
        info.setOpaque(true);
        /**
         * Toinen inforuutu ja sen väri.
         */
        this.info2 = new JLabel("");
        info2.setBackground(Color.BLACK);
        info2.setForeground(Color.GRAY);
        info2.setOpaque(true);
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

        JPanel paneeli = new JPanel(new GridLayout(1, 2));
        paneeli.add(info);
        paneeli.add(info2);
        container.add(paneeli, BorderLayout.NORTH);
    }

    /**
     * Lisää Pelikuuntelijan.
     *
     * Pelikuuntelija pyörittää peliä.
     */
    public void lisaaKuuntelija() {
        frame.addKeyListener(new Pelikuuntelija(frame, p, hg, vk, info, info2));
    }

    public JFrame getFrame() {
        return frame;
    }
}
