import Rkc.TabelaHash.LoseLoseTabelaHash;
import Rkc.TabelaHash.PolinomialTabelaHash;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        int indexes = 600;
        var loseLose = new LoseLoseTabelaHash(indexes);
        var polinomial = new PolinomialTabelaHash(indexes);

        String caminhoArquivo = "female_names.txt";

        long startTime, endTime;
        long totalInsertionTimeLose = 0, totalInsertionTimePolinomial = 0;
        long totalSearchTimeLose = 0, totalSearchTimePolinomial = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                startTime = System.nanoTime();
                loseLose.put(linha);
                endTime = System.nanoTime();
                totalInsertionTimeLose += (endTime - startTime);

                startTime = System.nanoTime();
                polinomial.put(linha);
                endTime = System.nanoTime();
                totalInsertionTimePolinomial += (endTime - startTime);

                startTime = System.nanoTime();
                loseLose.contains(linha);
                endTime = System.nanoTime();
                totalSearchTimeLose += (endTime - startTime);

                startTime = System.nanoTime();
                polinomial.contains(linha);
                endTime = System.nanoTime();
                totalSearchTimePolinomial += (endTime - startTime);

                count++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        double avgInsertionTimeLose = (double) totalInsertionTimeLose / count;
        double avgInsertionTimePolinomial = (double) totalInsertionTimePolinomial / count;
        double avgSearchTimeLose = (double) totalSearchTimeLose / count;
        double avgSearchTimePolinomial = (double) totalSearchTimePolinomial / count;

        System.out.printf("Colisoes da Funcao Hash Lose: %d%n", loseLose.getColisoes());
        System.out.printf("Colisoes da Funcao Hash Polinomial: %d%n", polinomial.getColisoes());

        System.out.printf("Tempo total de inserção (LoseLose): %.3f ms%n", totalInsertionTimeLose / 1_000_000.0);
        System.out.printf("Tempo total de inserção (Polinomial): %.3f ms%n", totalInsertionTimePolinomial / 1_000_000.0);

        System.out.printf("Tempo total de busca (LoseLose): %.3f ms%n", totalSearchTimeLose / 1_000_000.0);
        System.out.printf("Tempo total de busca (Polinomial): %.3f ms%n", totalSearchTimePolinomial / 1_000_000.0);


        DefaultCategoryDataset datasetLoseLose = new DefaultCategoryDataset();
        Map<Integer, Integer> colisaoLose = loseLose.getColisoesPorIndice();
        for (Map.Entry<Integer, Integer> entry : colisaoLose.entrySet()) {
            datasetLoseLose.addValue(entry.getValue(), "Colisões", entry.getKey().toString());
        }

        JFreeChart chartLoseLose = ChartFactory.createBarChart(
                "Colisões por Índice - LoseLose",
                "Índice",
                "Número de Colisões",
                datasetLoseLose
        );

        ChartPanel chartPanelLoseLose = new ChartPanel(chartLoseLose);
        chartPanelLoseLose.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frameLoseLose = new JFrame("Gráfico de Colisões LoseLose");
        frameLoseLose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLoseLose.getContentPane().add(chartPanelLoseLose);
        frameLoseLose.pack();
        frameLoseLose.setVisible(true);

        DefaultCategoryDataset datasetPolinomial = new DefaultCategoryDataset();
        Map<Integer, Integer> colisaoPolinomial = polinomial.getColisoesPorIndice();
        for (Map.Entry<Integer, Integer> entry : colisaoPolinomial.entrySet()) {
            datasetPolinomial.addValue(entry.getValue(), "Colisões", entry.getKey().toString());
        }

        JFreeChart chartPolinomial = ChartFactory.createBarChart(
                "Colisões por Índice - Polinomial",
                "Índice",
                "Número de Colisões",
                datasetPolinomial
        );

        ChartPanel chartPanelPolinomial = new ChartPanel(chartPolinomial);
        chartPanelPolinomial.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame framePolinomial = new JFrame("Gráfico de Colisões Polinomial");
        framePolinomial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePolinomial.getContentPane().add(chartPanelPolinomial);
        framePolinomial.pack();
        framePolinomial.setVisible(true);

        System.out.println("Tabela Hash Lose (Número de chaves por índice):");
        loseLose.printHashTableWithSize();
        System.out.println("Tabela Hash Polinomial (Número de chaves por índice):");
        polinomial.printHashTableWithSize();
    }
}
