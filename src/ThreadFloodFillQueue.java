import Rkc.FloofFill.FloodFillQueue;
import Rkc.FloofFill.FloodFillStack;
import Rkc.FloofFill.Pixel;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ThreadFloodFillQueue extends Thread {
    private final int x;
    private final int y;
    private final int cor;
    private final BufferedImage img;
    private final int velocidade;

    public ThreadFloodFillQueue(int x, int y, int cor, BufferedImage img, int velocidade) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.img = img;
        this.velocidade = velocidade;
    }

    public void run()
    {
        new FloodFillQueue(this.x, this.y, this.cor, this.img, this.velocidade).start();
    }
}
