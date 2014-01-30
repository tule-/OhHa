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

public class Peliloppu implements Runnable {

    private JFrame frame;
    private int pisteet = 0;

    public void getPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Game Over!");

        frame.setPreferredSize(new Dimension(300, 160));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        JLabel loppu = new JLabel("Peli loppui, hirviöt saivat Sepon!");
        JLabel loppu2 = new JLabel("Seppo ei tule koskaan heräämään");
        JLabel loppu3 = new JLabel("tästä painajaisesta.");
        JLabel tyhja = new JLabel(" ");
        JLabel tyhja2 = new JLabel(" ");
        JLabel piste = new JLabel("Pisteesi: " + pisteet);
        JButton uusi = new JButton("Pelaa uudelleen?");

        container.add(loppu);
        container.add(loppu2);
        container.add(loppu3);
        container.add(tyhja);
        container.add(piste, BorderLayout.CENTER);
        container.add(tyhja2);
        container.add(uusi, BorderLayout.SOUTH);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, uusi);
        uusi.addActionListener(kuuntelija);
    }
}
