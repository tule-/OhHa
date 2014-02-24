package kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import valikot.Uusipeli;

/**
 * Kuuntelija siirtää takaisin aloitusruutuun.
 * 
 * Uusipelikuuntelija toimii Sepontarina -
 * sekä Peliloppu- ruuduissa.
 */
public class Uusipelikuuntelija implements ActionListener{
    
    private JFrame frame;
    /**
     * Uuden pelin aloittava nappi.
     */
    private JButton uusi;
    
    public Uusipelikuuntelija(JFrame frame, JButton uusipeli){
        this.frame = frame;
        this.uusi = uusipeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Uusipeli u = new Uusipeli();
        if(e.getSource() == uusi){
            u.run();
            frame.dispose();
        }
    }
}
