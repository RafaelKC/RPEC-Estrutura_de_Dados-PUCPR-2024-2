import FloodFill.FloodFill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputImage = new File("./img.png");
        BufferedImage img = ImageIO.read(inputImage);

        File outputImage = new File("./resultado.png");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o X do pixel inicial: ");
        int x = scanner.nextInt();
        System.out.print("Digite o Y do pixel inicial: ");
        int y = scanner.nextInt();


        System.out.print("Cores:\n1 - Vermelhor\n2 - Preto\n3 - Verde\n4 - Aleatorio\n");
        System.out.print("Digite o indice da cor que deseja usar para pintar: ");
        int cor = scanner.nextInt();

        System.out.print("Escolha uma velocidade de 0-10, sendo [0] MUITO devagar e [10] rapido: ");
        int velocidade = scanner.nextInt();

        FloodFill floodFill = new FloodFill(x, y, cor, img, velocidade);

        try {
            floodFill.start();
        } finally {
            ImageIO.write(img, "png", outputImage);

        }

    }
}