package Rkc.FloofFill;

import Rkc.Queue.DynamicQueue;
import Rkc.Stack.DynamicStack;

import java.awt.image.BufferedImage;

public class FloodFillStack extends FloodFill {

    public FloodFillStack(int x, int y, int cor, BufferedImage img, int velocidade) {
        super(x, y, cor, img, velocidade);
    }

    public void start() {
        pintarPixel(this.pixelInicial, this.corPintar);
        pintarAdjacentes(this.getAdjacentes(pixelInicial));
        updateImage();
    }

    private void pintarAdjacentes(DynamicStack<Pixel> adjacentes) {
        DynamicStack<Pixel> adjacentesDosAdjacentes = new DynamicStack<>();
        while (!adjacentes.isEmpty()) {
            Pixel p = adjacentes.pop();
            this.pintarPixel(p, this.corPintar);

            DynamicStack<Pixel> ad = getAdjacentes(p);
            while (!ad.isEmpty()) {
                Pixel paa = ad.pop();
                pintarPixel(paa, this.corPintar);
                adjacentesDosAdjacentes.push(paa);
            }
        }
        updateImage();

        if (!adjacentesDosAdjacentes.isEmpty()) {
            pintarAdjacentes(adjacentesDosAdjacentes);
        }

    }

    private DynamicStack<Pixel> getAdjacentes(Pixel pixel) {
        DynamicStack<Pixel> pixelsAdjacentes = new DynamicStack<>();

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
