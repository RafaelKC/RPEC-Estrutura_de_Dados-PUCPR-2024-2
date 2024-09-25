package Rkc.FloofFill;

import Rkc.Queue.DynamicQueue;
import Rkc.Stack.DynamicStack;

import java.awt.image.BufferedImage;

public class FloodFillStack extends FloodFill {

    public FloodFillStack(int x, int y, int cor, BufferedImage img, int velocidade) {
        super(x, y, cor, img, velocidade, "Stack");
    }

    public void start() {
        pintarPixel(this.pixelInicial, this.corPintar);
        pintarAdjacentes(this.getAdjacentes(pixelInicial, new DynamicStack<>()));
        updateImage();
    }

    private void pintarAdjacentes(DynamicStack<Pixel> adjacentes) {
        var pixel = adjacentes.pop();

        var count = 0;
        while (pixel != null) {
            this.pintarPixel(pixel, this.corPintar);
            this.getAdjacentes(pixel, adjacentes);

            if (adjacentes.isEmpty()) {
                pixel = null;
            } else {
                pixel = adjacentes.pop();
            }

            count++;

            if (count >= 60) {
                count = 0;
                updateImage();
            }
        }
    }

    private DynamicStack<Pixel> getAdjacentes(Pixel pixel, DynamicStack<Pixel> pixelsAdjacentes) {
        Pixel pixelDeCima = new Pixel(pixel.getX(), pixel.getY() - 1);
        Pixel pixelDeBaixo = new Pixel(pixel.getX(), pixel.getY() + 1);
        Pixel pixelDaDireita = new Pixel(pixel.getX() + 1, pixel.getY());
        Pixel pixelDaEsquerda = new Pixel(pixel.getX() - 1, pixel.getY());

        if (this.nosLimites(pixelDeCima)) {
            if (this.mesmaCorQueOInicial(pixelDeCima)) {
                pixelsAdjacentes.push(pixelDeCima);
            }
        }
        if (this.nosLimites(pixelDeBaixo)) {
            if (this.mesmaCorQueOInicial(pixelDeBaixo)) {
                pixelsAdjacentes.push(pixelDeBaixo);
            }
        }
        if (this.nosLimites(pixelDaDireita)) {
            if (this.mesmaCorQueOInicial(pixelDaDireita)) {
                pixelsAdjacentes.push(pixelDaDireita);
            }
        }
        if (this.nosLimites(pixelDaEsquerda)) {
            if (this.mesmaCorQueOInicial(pixelDaEsquerda)) {
                pixelsAdjacentes.push(pixelDaEsquerda);
            }
        }

        return pixelsAdjacentes;
    }
}
