import Rkc.FloodFill.FloodFillStack;

import java.awt.image.BufferedImage;

public class ThreadFloodFillStack extends Thread {
    private final int x;
    private final int y;
    private final int cor;
    private final BufferedImage img;
    private final int velocidade;

    public ThreadFloodFillStack(int x, int y, int cor, BufferedImage img, int velocidade) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.img = img;
        this.velocidade = velocidade;
    }

    public void run()
    {
        new FloodFillStack(this.x, this.y, this.cor, this.img, this.velocidade).start();
    }
}
