import Rkc.Sorting.Sorting;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SortTestes extends ApplicationFrame {
    public SortTestes(String title) {
        super(title);
        JFreeChart barChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        String[] csvFiles = {
                "docs/sort_docs/conjuntosDeDados/decrescente_100.csv",
                "docs/sort_docs/conjuntosDeDados/decrescente_1000.csv",
                "docs/sort_docs/conjuntosDeDados/decrescente_10000.csv"
        };

        String[] dataLabels = {"100 elementos", "1000 elementos", "10000 elementos"};
        String[] sortTypes = {"Insertion", "Bubble", "Quick"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        long[] totalInsertionTimes = new long[csvFiles.length];
        long[] totalBubbleTimes = new long[csvFiles.length];
        long[] totalQuickTimes = new long[csvFiles.length];

        for (int i = 0; i < csvFiles.length; i++) {
            ArrayList<Integer> data = readCSV(csvFiles[i], ",");
            totalInsertionTimes[i] = measureSortTime(data, "Insertion");
            totalBubbleTimes[i] = measureSortTime(data, "Bubble");
            totalQuickTimes[i] = measureSortTime(data, "Quick");

            dataset.addValue(TimeUnit.MILLISECONDS.convert(totalInsertionTimes[i], TimeUnit.NANOSECONDS), "Insertion Sort", dataLabels[i]);
            dataset.addValue(TimeUnit.MILLISECONDS.convert(totalBubbleTimes[i], TimeUnit.NANOSECONDS), "Bubble Sort", dataLabels[i]);
            dataset.addValue(TimeUnit.MILLISECONDS.convert(totalQuickTimes[i], TimeUnit.NANOSECONDS), "Quick Sort", dataLabels[i]);
        }

        for (int i = 0; i < csvFiles.length; i++) {
            System.out.println("Médias para " + dataLabels[i] + ":");
            System.out.println("Insertion Sort: " + TimeUnit.MILLISECONDS.convert(totalInsertionTimes[i], TimeUnit.NANOSECONDS) + " ms");
            System.out.println("Bubble Sort: " + TimeUnit.MILLISECONDS.convert(totalBubbleTimes[i], TimeUnit.NANOSECONDS) + " ms");
            System.out.println("Quick Sort: " + TimeUnit.MILLISECONDS.convert(totalQuickTimes[i], TimeUnit.NANOSECONDS) + " ms");
        }

        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Desempenho de Algoritmos de Ordenação",
                "Tamanho do Conjunto de Dados",
                "Tempo (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 0, 255)); // Insertion
        renderer.setSeriesPaint(1, new Color(0, 128, 0)); // Bubble
        renderer.setSeriesPaint(2, new Color(255, 0, 0)); // Quick

        renderer.setMaximumBarWidth(0.1);

        plot.setOutlineVisible(false);
        plot.setInsets(new RectangleInsets(10, 10, 10, 10));

        return barChart;
    }

    private ArrayList<Integer> readCSV(String filePath, String delimiter) {
        ArrayList<Integer> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (String value : values) {
                    try {
                        data.add(Integer.parseInt(value.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Dado inválido: " + value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private long measureSortTime(ArrayList<Integer> data, String sortType) {
        ArrayList<Integer> copy = new ArrayList<>(data);
        long startTime = System.nanoTime();
        switch (sortType) {
            case "Insertion":
                Sorting.InsertSort(copy);
                break;
            case "Bubble":
                Sorting.BobbleSort(copy);
                break;
            case "Quick":
                Sorting.QuickSort(copy);
                break;
        }
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        SortTestes chart = new SortTestes("Gráfico de Desempenho de Algoritmos");
        chart.pack();
        chart.setVisible(true);
    }
}
