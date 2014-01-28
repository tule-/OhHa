package valikot;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Uusipeli implements Runnable {
    
    private JFrame frame;
    
    @Override
    public void run() {
        this.frame = new JFrame("Seppo Peli 0.1");
        
        frame.setPreferredSize(new Dimension(250, 200));
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
        
        JLabel info = new JLabel("SEPPO PELI");
        JLabel tekija = new JLabel("by TuBa");
        JButton tarina = new JButton("Sepon tarina");
        JButton uusi = new JButton("Aloita peli");
        
        container.add(info);
        container.add(tekija);
        container.add(uusi);
        container.add(tarina);

        Alkukuuntelija kuuntelija = new Alkukuuntelija(frame, uusi, tarina);
        uusi.addActionListener(kuuntelija);
        tarina.addActionListener(kuuntelija);
    }
}
