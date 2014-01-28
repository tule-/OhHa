package valikot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Sepontarina  implements Runnable{
    
    private JFrame frame;
    
    @Override
    public void run() {
        this.frame = new JFrame("Seppon tarina");
        
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        frame.setLocation(screenSize.width / 3, screenSize.height / 3);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        
        JLabel info = new JLabel("Coming soon");
        JButton uusi = new JButton("Aloita peli");
        
        container.add(info, BorderLayout.CENTER);
        container.add(uusi, BorderLayout.SOUTH);

        Uusipelikuuntelija kuuntelija = new Uusipelikuuntelija(frame, uusi);
        uusi.addActionListener(kuuntelija);
    }
}
