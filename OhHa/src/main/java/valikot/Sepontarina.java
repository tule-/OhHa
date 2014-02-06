package valikot;

import kuuntelijat.Uusipelikuuntelija;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Pelaaja voi lukea Sepon sydäntä särkevän tarinan.
 * 
 * Ruudun alalaidassa on painike jolla pelaaja aloittaa
 * uuden pelin.
 */
public class Sepontarina  implements Runnable{
    
    private JFrame frame;
    
    /**
     * Luo ruudun, asettaa sen dimensiot sekä lisää komponentit.
     */
    @Override
    public void run() {
        this.frame = new JFrame("Seppon tarina");
        
        frame.setPreferredSize(new Dimension(320, 280));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Luo valikkoon lisättävät komponentit.
     * 
     * Sisältää pääasiassa tekstiä.
     * 
     * @param container 
     */
    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel info = new JLabel("Eräänä iltana tavalliseen tapaansa Seppo lensi");
        JLabel info2 = new JLabel("ulos kantabaaristaan ja ryömi tuttuun katuojaan.");
        JLabel info3 = new JLabel("Hän päätti ottaa pienet nokoset kotoisassa");
        JLabel info4 = new JLabel("viemärivedessä.");
        JLabel info5 = new JLabel(" ");
        JLabel info6 = new JLabel("Herättyään Seppo kompuroi ylös ja huomasi olevansa");
        JLabel info7 = new JLabel("keskellä mitä voisi vain kuvailla areenaksi.");
        JLabel info8 = new JLabel("Kauhukseen Seppo näkee seinällä suuaukon, josta");
        JLabel info9 = new JLabel("kantautuu pahaenteistä murinaa.");
        JLabel info10 = new JLabel(" ");
        JLabel info11 = new JLabel("Onko tämä kaikkien aikojen pahin liskojen yö");
        JLabel info12 = new JLabel("vai onko Seppo oikeasti kiipelissä?");
        JLabel info13 = new JLabel("Se jää vain nähtäväksi.");
        
        JButton uusi = new JButton("Aloita peli");
        
        container.add(info);
        container.add(info2);
        container.add(info3);
        container.add(info4);
        container.add(info5);
        container.add(info6);
        container.add(info7);
        container.add(info8);
        container.add(info9);
        container.add(info10);
        container.add(info11);
        container.add(info12);
        container.add(info13);
        
        container.add(uusi, BorderLayout.SOUTH);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, uusi);
        uusi.addActionListener(kuuntelija);
    }
}
