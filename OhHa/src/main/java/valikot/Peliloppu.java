package valikot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Peliloppu implements Runnable {

    private JFrame frame;
    private int pisteet = 0;

    public void getPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Game Over!");

        frame.setPreferredSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        JLabel loppu = new JLabel("Peli loppui, hirviöt saivat Sepon!");
        JLabel piste = new JLabel("Pisteesi: " + pisteet);
        JButton uusi = new JButton("Pelaa uudelleen?");

        container.add(loppu, BorderLayout.NORTH);
        container.add(piste, BorderLayout.CENTER);
        container.add(uusi, BorderLayout.SOUTH);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, uusi);
        uusi.addActionListener(kuuntelija);
    }
}
