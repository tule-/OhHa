package logiikka;

import java.awt.Graphics;

public abstract class Hahmo {

    private int X;
    private int Y;

    public Hahmo(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public void siirra(int dx, int dy) {
        X += dx;
        Y += dy;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    public abstract void piirra(Graphics graphics);
}
