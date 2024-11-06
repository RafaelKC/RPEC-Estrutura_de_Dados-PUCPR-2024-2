import Rkc.TabelaHash.LoseLoseTabelaHash;
import Rkc.TabelaHash.PolinomialTabelaHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        var loseLose = new LoseLoseTabelaHash(300);
        var polinomial = new PolinomialTabelaHash(300);


        String caminhoArquivo = "female_names.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                loseLose.put(linha);
                polinomial.put(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("asdasd");
    }
}