package FloodFill;

import Rkc.Queue.DynamicQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {
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

    private static Color getRandomColor() {
        return new Color((int) (Math.random() * 0x1000000));
    }

    private void pintarPixel(Pixel pixel, int cor) {
        this.img.setRGB(pixel.getX(), pixel.getY(), cor);
    }

    private DynamicQueue<Pixel> getAdjacentes(Pixel pixel) {
        DynamicQueue<Pixel> pixelsAdjacentes = new DynamicQueue<>();

        Pixel pixelDeCima = new Pixel(pixel.getX(), pixel.getY() - 1);
        Pixel pixelDeBaixo = new Pixel(pixel.getX(), pixel.getY() + 1);
        Pixel pixelDaDireita = new Pixel(pixel.getX() + 1, pixel.getY());
        Pixel pixelDaEsquerda = new Pixel(pixel.getX() - 1, pixel.getY());

        if (this.nosLimites(pixelDeCima)) {
            if (this.mesmaCorQueOInicial(pixelDeCima)) {
                pixelsAdjacentes.add(pixelDeCima);
            }
        }
        if (this.nosLimites(pixelDeBaixo)) {
            if (this.mesmaCorQueOInicial(pixelDeBaixo)) {
                pixelsAdjacentes.add(pixelDeBaixo);
            }
        }
        if (this.nosLimites(pixelDaDireita)) {
            if (this.mesmaCorQueOInicial(pixelDaDireita)) {
                pixelsAdjacentes.add(pixelDaDireita);
            }
        }
        if (this.nosLimites(pixelDaEsquerda)) {
            if (this.mesmaCorQueOInicial(pixelDaEsquerda)) {
                pixelsAdjacentes.add(pixelDaEsquerda);
            }
        }

        return pixelsAdjacentes;
    }

    private boolean mesmaCorQueOInicial(Pixel pixel) {
        return this.img.getRGB(pixel.getX(), pixel.getY()) == this.pixelInicial.getRgb();
    }

    private boolean nosLimites(Pixel pixel) {
        return pixel.getX() >= 0 && pixel.getY() >= 0 && pixel.getX() < img.getWidth() && pixel.getY() < img.getHeight();
    }

    public void start() {
        pintarPixel(this.pixelInicial, this.corPintar);
        pintarAdjacentes(this.getAdjacentes(pixelInicial));
        updateImage();
    }

    private void pintarAdjacentes(DynamicQueue<Pixel> adjacentes) {
        DynamicQueue<Pixel> adjacentesDosAdjacentes = new DynamicQueue<>();
        while (!adjacentes.isEmpty()) {
            Pixel p = adjacentes.remove();
            this.pintarPixel(p, this.corPintar);

            DynamicQueue<Pixel> ad = getAdjacentes(p);
            while (!ad.isEmpty()) {
                Pixel paa = ad.remove();
                pintarPixel(paa, this.corPintar);
                adjacentesDosAdjacentes.add(paa);
            }
        }
        updateImage();

        if (!adjacentesDosAdjacentes.isEmpty()) {
            pintarAdjacentes(adjacentesDosAdjacentes);
        }

    }

    private void updateImage() {
        SwingUtilities.invokeLater(() -> frame.repaint());
        try {
            Thread.sleep(13 - this.velocidade);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}



