package Rkc.FloodFill;

public class Pixel {
    private final int x;
    private final int y;
    private int rgb;

    public Pixel(int x, int y, int cor) {
        this.x = x;
        this.y = y;
        this.rgb = cor;
    }

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRgb() {
        return rgb;
    }
}
