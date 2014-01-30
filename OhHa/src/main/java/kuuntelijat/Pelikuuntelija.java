package kuuntelijat;

import valikot.Peliloppu;
import hahmot.Hirvio;
import hahmot.Pelaaja;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logiikka.HirvioGeneraattori;
import logiikka.Kuolema;
import logiikka.Pistelaskuri;
import logiikka.Voimakentta;

public class Pelikuuntelija implements KeyListener {

    private Component Component;
    private int laskuri = 10;
    
    private Pelaaja p;
    private HirvioGeneraattori hg;
    
    private Voimakentta vk;
    private Pistelaskuri pl;

    public Pelikuuntelija(Component component, Pelaaja p, HirvioGeneraattori hg, Voimakentta vk) {
        this.Component = component;
        this.p = p;
        this.hg = hg;
        
        this.vk = vk;
        this.pl = new Pistelaskuri();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Kuolema k = new Kuolema();
        Peliloppu loppu = new Peliloppu();
        
        //PELAAJAN LIIKE
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.siirra(0, -25);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p.siirra(0, 25);
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            p.siirra(-25, 0);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            p.siirra(25, 0);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            vk.hyokkaa(p.getX(), p.getY());
        }

        //HIRVIÖN LIIKE
        for (Hirvio h1 : hg.getLista()) {
            h1.siirra(0, 0);
        }
        
        //KOORDINAATIT
        System.out.println("pelaaja: " +  p.getX() + " " + p.getY());
        
        //PISTEET
        System.out.println("Pisteesi: " + pl.getPisteet());
        
        //LASKURI
        System.out.println("uusi hirviö: " + laskuri);
        
        //KUOLEMA TARKISTUS
        for (Hirvio h1 : hg.getLista()) {
            if(k.pelaajakuollut(p.getX(), p.getY(), h1.getX(), h1.getY()) == true){
                loppu.getPisteet(pl.getPisteet());
                loppu.run();
                Component.setVisible(false);
            }
        }
        
        //TARKISTUTS ONKO HIRVIÖ KUOLLUT
        for (int i = 0; i < hg.getLista().size(); i++) {
                if(k.hirviokuollut(hg.getLista().get(i).getX(), hg.getLista().get(i).getY(), vk) ==  true){
                    hg.tapaHirvio(i);
                    System.out.println("HIRVIÖ KUOLI!");
                    pl.lisaa();
                }
            }
        
        //UUSI HIRVIO JOKA 10 KIERROS
        laskuri--;
        if(laskuri == 0){
            hg.lisaa(0);
            laskuri = 10;
        }
        
        System.out.println("-----------------");
        
        Component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            vk.nollaa();
        }
    }
}
