import Rkc.CodigoMorse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Estrutura de Dados ======");
        System.out.println("1 - FloodFill usando queue e stack");
        System.out.println("2 - Codigo morse com arvore binaria");
        System.out.println();
        System.out.print("Digite o indece da opcao que deseja: ");
        int opcao = scanner.nextInt();
        System.out.println();

        switch (opcao){
            case 1: FloodFillOption(scanner); break;
            case 2: ArvoreBinariaOption(scanner); break;
        }

    }

    private static void ArvoreBinariaOption(Scanner scanner) {
        try {
            // .-.. ..- .. ... / --- - .- ...- .. ---
            scanner.nextLine();

            System.out.println("(obs: para 'espaco' use /) ");
            System.out.print("Digite o codigo que deseja decodificar: ");

            String morse = scanner.nextLine();
            System.out.println();

            CodigoMorse codigoMorse = new CodigoMorse();
            System.out.println("Decodificado: ");
            System.out.println(codigoMorse.decodificar(morse));

            System.out.println("\n1 - Decodicar outro codigo\n2 - Encerrar");
            System.out.print("Digite o indice: ");
            int i = scanner.nextInt();
            System.out.println();

            switch (i){
                case 1: ArvoreBinariaOption(scanner); break;
                case 2: break;
            }
        } catch (Exception e) {
            System.out.print("Erro, caracter inválido");
            ArvoreBinariaOption(scanner);
        }
    }


    static void FloodFillOption(Scanner scanner) throws IOException {
        File inputImageStack = new File("./img-stack.png");
        BufferedImage imgStack = ImageIO.read(inputImageStack);

        File inputImageQueue = new File("./img-queue.png");
        BufferedImage imgQueue = ImageIO.read(inputImageQueue);

        File outputImageStack = new File("./resultado-stack.png");
        File outputImageQueue = new File("./resultado-queue.png");


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