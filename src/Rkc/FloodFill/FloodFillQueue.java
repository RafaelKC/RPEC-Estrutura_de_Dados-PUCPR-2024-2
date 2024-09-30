package Rkc.FloodFill;

import Rkc.Queue.DynamicQueue;

import java.awt.image.BufferedImage;

public class FloodFillQueue extends FloodFill {

    public FloodFillQueue(int x, int y, int cor, BufferedImage img, int velocidade) {
        super(x, y, cor, img, velocidade, "Queue");
        this.frame.setLocation(1000, 500);
    }

    public void start() {
        pintarPixel(this.pixelInicial, this.corPintar);
        pintarAdjacentes(this.getAdjacentes(pixelInicial));
        updateImage();
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
}









