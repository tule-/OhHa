package kuuntelijat;

import valikot.Peliloppu;
import hahmot.Hirvio;
import hahmot.Pelaaja;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import logiikka.HirvioGeneraattori;
import logiikka.Kuolema;
import logiikka.Pistelaskuri;
import logiikka.Voimakentta;

/**
 * Pelikuuntelija vastaa pelin pyörittämisestä.
 *
 * Se kuuntelee napin painalluksia sekä piirtää komponentit ruudulle uudelleen
 * joka painalluksen jälkeen.
 */
public class Pelikuuntelija implements KeyListener {

    private Component Component;
    private Pelaaja p;
    private HirvioGeneraattori hg;
    private Voimakentta vk;
    private Pistelaskuri pl;
    private int laskuri = 11;
    private JLabel info;
    private Timer timer;

    /**
     * Alustaa pelaajan, hirviögeneraattorin, voimakentän sekä inforuudun.
     *
     * @param component
     * @param p pelaaja
     * @param hg hirviögeneraattori
     * @param vk voimakenttä
     * @param info inforuutu
     */
    public Pelikuuntelija(Component component, Pelaaja p, HirvioGeneraattori hg, Voimakentta vk, JLabel info) {
        this.Component = component;
        this.p = p;
        this.hg = hg;

        this.vk = vk;
        this.pl = new Pistelaskuri();

        this.info = info;
        this.timer = new Timer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Kuuntelee napin painalluksia.
     * 
     * @param e painettu nappi.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Kuolema k = new Kuolema();
        Peliloppu loppu = new Peliloppu();


        /**
         * Pelaajan liike.
         */
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.siirra(0, -25);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p.siirra(0, 25);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p.siirra(-25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.siirra(25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            vk.hyokkaa(p.getX(), p.getY());
        }


        /**
         * Kello jonka mukaan hirviöt liikkuvat.
         */
        if (laskuri == 11) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    for (Hirvio h1 : hg.getLista()) {
                        h1.siirra(0, 0);
                    }
                    Component.repaint();
                }
            };
            timer.schedule(task, java.util.Calendar.getInstance().getTime(), 450);
        }


        /**
         * Kuolema tarkistus pelaajalle.
         */
        for (Hirvio h1 : hg.getLista()) {
            if (k.pelaajakuollut(p.getX(), p.getY(), h1.getX(), h1.getY()) == true) {
                loppu.getPisteet(pl.getPisteet());
                loppu.run();
                Component.setVisible(false);
            }
        }

        /**
         * Kuolema tarkistus hirviölle.
         */
        for (int i = 0; i < hg.getLista().size(); i++) {
            if (k.hirviokuollut(hg.getLista().get(i).getX(), hg.getLista().get(i).getY(), vk) == true) {
                hg.tapaHirvio(i);
                pl.lisaa();
            }
        }


        //KELLON ALUSTUS
        if (laskuri == 11) {
            laskuri = 10;
        }


        //UUSI HIRVIO JOKA 10 KIERROS
        laskuri--;
        if (laskuri == 0) {
            hg.lisaa(0);
            laskuri = 10;
        }


        /**
         * Inforuudulla näkyvät tiedot.
         */
        info.setText("Pisteet: " + pl.getPisteet() + "     ||     Uusi hirviö: " + laskuri);


        Component.repaint();
    }

    /**
     * Kuuntelee irroitettuja nappeja.
     * 
     * @param e irroitettu nappi
     */
    @Override
    public void keyReleased(KeyEvent e) {
        /**
         * Nollaa voimakentän sen jälkeen kun se on laukaistu.
         */
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            vk.nollaa();
        }
        Component.repaint();
    }
}
