package Rkc.FloofFill;

import Rkc.Stack.DynamicStack;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FloodFill  {
    BufferedImage image;

    public FloodFill(String imagePath) throws IOException {
        File file = new File(imagePath);
        image = ImageIO.read(file);
    }

    public void applyFloodFill(Pixel initialPixel, Color newColor) throws IOException {
        var clrInitial = image.getRGB(initialPixel.x, initialPixel.y);
        var rgbInitial = new Color(clrInitial);

        var pilha = new DynamicStack<Pixel>();
        recolorizeStack(initialPixel, pilha, newColor, rgbInitial);
    }

    public void showResult() {
        new ImageSlideshow("src/out", image.getWidth(), image.getHeight());
    }

    private void recolorizeStack(Pixel pixel, DynamicStack<Pixel> pilha, Color newColor, Color rgbInitial) throws IOException {
        saveImage(String.format("src/out/%s.png", 0));
        var saveCount = 1;

        var saveImageEach = 1750;
        var pixelCount = 0;

        while (pixel != null) {
            System.out.println("Pixel " + pixel.x + ", " + pixel.y);

            recolorizePixel(pixel, newColor);
            addAdjactes(pixel, rgbInitial, pilha);
            pixelCount++;

            if (!pilha.isEmpty()) {
                pixel = pilha.pop();
            } else {
                pixel = null;
            }

            if (pixelCount % saveImageEach == 0) {
                saveImage(String.format("src/out/%s.png", saveCount));
                saveCount++;
            }
        }

    }

    private void addAdjactes(Pixel pixel, Color rgbInitial, DynamicStack<Pixel> pilha) {
        var left = new Pixel(pixel.x - 1, pixel.y);
        var right = new Pixel(pixel.x + 1, pixel.y);
        var top = new Pixel(pixel.x, pixel.y - 1);
        var button = new Pixel(pixel.x, pixel.y + 1);

        tryAddPixel(left, rgbInitial, pilha);
        tryAddPixel(right, rgbInitial, pilha);
        tryAddPixel(top, rgbInitial, pilha);
        tryAddPixel(button, rgbInitial, pilha);
    }

    private void tryAddPixel(Pixel pixel, Color rgbInitial, DynamicStack<Pixel> pilha) {
        try {
            var pixelRgb = new Color(image.getRGB(pixel.x, pixel.y));
            if (pixelRgb.equals(rgbInitial)) { pilha.push(pixel); }
        } catch (Exception _) {
        }
    }

    private void saveImage(String path) throws IOException {
        var fileOutput = new File(path);
        var pathSplit = path.split("\\.");
        var type = pathSplit[pathSplit.length - 1];
        ImageIO.write(image, type, fileOutput);
    }

    private void recolorizePixel(Pixel pixel, Color color) {
        image.setRGB(pixel.x, pixel.y, color.getRGB());
    }
}
