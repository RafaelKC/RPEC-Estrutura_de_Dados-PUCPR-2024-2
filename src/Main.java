import Rkc.FloofFill.FloodFill;
import Rkc.FloofFill.Pixel;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
     var path = "src/img.png";

     var initialPixel = new Pixel(50, 50);
     var rgb = new Color(0, 211, 230);

     var floodFill = new FloodFill(path);
     floodFill.applyFloodFill(initialPixel, rgb);
     floodFill.showResult();
    }
}