package Rkc.FloofFill;

import Rkc.Queue.DynamicQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class FloodFill {
    Pixel pixelInicial;
    BufferedImage img;
    int corPintar;
    JFrame frame = new JFrame();
    int velocidade;

    public FloodFill(int x, int y, int cor, BufferedImage img, int velocidade) {
        this.pixelInicial = new Pixel(x, y, img.getRGB(x, y));
        this.img = img;
        this.velocidade = velocidade;
        switch (cor) {
            case 1:
                this.corPintar = Color.RED.getRGB();
                break;
            case 2:
                this.corPintar = Color.BLACK.getRGB();
                break;
            case 3:
                this.corPintar = Color.GREEN.getRGB();
                break;
            case 4:
                this.corPintar = getRandomColor().getRGB();
                break;
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
    }

    public abstract void start();

    protected void updateImage() {
        SwingUtilities.invokeLater(() -> frame.repaint());
        try {
            Thread.sleep(13 - this.velocidade);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Color getRandomColor() {
        return new Color((int) (Math.random() * 0x1000000));
    }

    protected void pintarPixel(Pixel pixel, int cor) {
        this.img.setRGB(pixel.getX(), pixel.getY(), cor);
    }

    protected boolean mesmaCorQueOInicial(Pixel pixel) {
        return this.img.getRGB(pixel.getX(), pixel.getY()) == this.pixelInicial.getRgb();
    }

    protected boolean nosLimites(Pixel pixel) {
        return pixel.getX() >= 0 && pixel.getY() >= 0 && pixel.getX() < img.getWidth() && pixel.getY() < img.getHeight();
    }
}
