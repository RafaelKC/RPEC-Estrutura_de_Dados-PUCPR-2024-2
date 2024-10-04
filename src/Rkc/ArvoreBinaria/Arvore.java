package Rkc.ArvoreBinaria;
import Rkc.List.Node;
import Rkc.Stack.DynamicStack;


public class Arvore {
    private Node<Integer> raiz;

    public Arvore(){
    raiz = null;
    }

    public void inserirNode(Node<Integer> node){
        if(raiz == null){
            raiz = node;
            return;
        }

        Node<Integer> nodeAtual = raiz;
        while(nodeAtual.getValue() != null){
            Node<Integer> pai = nodeAtual;

            if (node.getValue().equals(nodeAtual.getValue())){
                return;
            }

            if (node.getValue() < nodeAtual.getValue() ){
                nodeAtual = nodeAtual.getLeftChild();
                if (nodeAtual == null){
                    pai.setLeftChild(node);
                    return;
                }
            }

            nodeAtual = nodeAtual.getRightChild();
            if (nodeAtual == null) {
                pai.setRightChild(node);
                return;
            }


        }

    }
    public Node<Integer> encontrarNodePeloValor(int value) {
        Node<Integer> nodeAtual = raiz;
        while (nodeAtual.getValue() != value) {
            if (value < nodeAtual.getValue()) {
                nodeAtual = nodeAtual.getLeftChild();
            } else {
                nodeAtual = nodeAtual.getRightChild();
            }
            if (nodeAtual == null) {
                return null;
            }
        }
        return nodeAtual;
    }
    public void printArvore() {
        DynamicStack<Node<Integer>> globalStack = new DynamicStack<>();
        globalStack.push(raiz);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty) {
            DynamicStack<Node<Integer>> localStack = new DynamicStack<>();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node<Integer> temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}
