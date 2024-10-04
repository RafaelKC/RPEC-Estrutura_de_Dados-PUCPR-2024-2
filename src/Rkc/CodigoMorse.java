package Rkc;

import Rkc.ArvoreBinaria.ArvoreMorse;
import Rkc.List.Node;

public class CodigoMorse {

    private final ArvoreMorse arvore = new ArvoreMorse();

    public String decodificar(String codigo) {
        String[] palavras = codigo.split("/");
        StringBuilder decodificado = new StringBuilder();

        for (String palavra : palavras) {
            String[] letras = palavra.trim().split(" ");
            for (String letra : letras) {
                String[] morse = letra.split("");
                Node<String> nodeAtual = arvore.getRaiz();

                for (String s : morse) {
                    if (s.equals(".")) {
                        nodeAtual = nodeAtual.getLeftChild();
                        continue;
                    } else if (s.equals("-")) {
                        nodeAtual = nodeAtual.getRightChild();
                    } else {
                        nodeAtual = null;
                        break;
                    }
                }
                if (nodeAtual != null) {
                    decodificado.append(nodeAtual.getValue());
                }

            }
            decodificado.append(" ");
        }
        return decodificado.toString();
    }





}
