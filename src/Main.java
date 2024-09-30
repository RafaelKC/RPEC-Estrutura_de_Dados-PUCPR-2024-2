import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputImageStack = new File("./img-stack.png");
        BufferedImage imgStack = ImageIO.read(inputImageStack);

        File inputImageQueue = new File("./img-queue.png");
        BufferedImage imgQueue = ImageIO.read(inputImageQueue);

        File outputImageStack = new File("./resultado-stack.png");
        File outputImageQueue = new File("./resultado-queue.png");

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

        System.out.print("Escolha uma qual estrutura de dados você quer: \n1 - Stack \n2 - Queue \n3 - Ambos \n");
        System.out.print("Digite o indice da estrutura que deseja usar: ");
        int estrutura = scanner.nextInt();

        var stackThread = new ThreadFloodFillStack(x, y, cor, imgStack, velocidade);
        var queueThread = new ThreadFloodFillQueue(x, y, cor, imgQueue, velocidade);

        try {
            if (estrutura == 1) {
                stackThread.start();
            } else if(estrutura == 2) {
                queueThread.start();
            } else {

                stackThread.start();
                queueThread.start();
            }
        } finally {
            ImageIO.write(imgStack, "png", outputImageStack);
            ImageIO.write(imgQueue, "png", outputImageQueue);
        }

    }
}