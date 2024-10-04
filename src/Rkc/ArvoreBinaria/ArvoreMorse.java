package Rkc.ArvoreBinaria;

import Rkc.List.Node;
import Rkc.List.StaticList;
import Rkc.Stack.DynamicStack;

public class ArvoreMorse {
    private final Node<String> raiz = new Node<>("inicio");
    private final StaticList<StaticList<String>> charParaCodigo  = new StaticList<>(36);

    public ArvoreMorse() {
        preencherCharParaCodigo();
        montarArvore();
        printArvore();
    }

    public Node<String> getRaiz() {
        return raiz;
    }
    private void preencherCharParaCodigo() {
        String[] alfabeto = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0".split(" ");
        String[] morse = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. .---- ..--- ...-- ....- ..... -.... --... ---.. ----. -----".split(" ");

        for(int i = 0; i < morse.length; i++) {
            StaticList<String> ch = new StaticList<>(2);
            ch.setData(alfabeto[i], 0);
            ch.setData(morse[i], 1);

            // System.out.printf("%s -> %s\n", ch.getData(0), ch.getData(1));

            charParaCodigo.setData(ch, i);
        }


    }

    public void montarArvore(){
        for(int i = 0; i < 36; i++) {
            StaticList<String> letra = charParaCodigo.getData(i);

            String[] morseSeparado = letra.getData(1).split("");

            Node<String> nodeAtual = getRaiz();
            for (String s : morseSeparado) {
                if (s.equals("-")) {
                    if (nodeAtual.getRightChild() != null) {
                        nodeAtual = nodeAtual.getRightChild();
                        continue;
                    }
                    nodeAtual.setRightChild(new Node<>("*"));
                    nodeAtual = nodeAtual.getRightChild();
                    continue;
                }
                if (nodeAtual.getLeftChild() != null) {
                    nodeAtual = nodeAtual.getLeftChild();
                    continue;
                }
                nodeAtual.setLeftChild(new Node<>("*"));
                nodeAtual = nodeAtual.getLeftChild();
            }

            nodeAtual.setValue(letra.getData(0));

        }

    }
    public void printArvore() {
        DynamicStack<Node<String>> globalStack = new DynamicStack<>();
        globalStack.push(raiz);
        int gaps = 64;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty) {
            DynamicStack<Node<String>> localStack = new DynamicStack<>();
            isRowEmpty = true;

            for (int j = 0; j < gaps / 2; j++) {
                System.out.print(' ');
            }

            while (!globalStack.isEmpty()) {
                Node<String> temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(String.format("%2s", temp.getValue()));
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("  ");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < gaps - 2; j++) {
                    System.out.print(' ');
                }
            }

            System.out.println();
            gaps /= 2;


            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(separator);
    }
}
