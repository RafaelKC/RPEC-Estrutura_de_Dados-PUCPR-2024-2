import Rkc.Stack.DynamicStack;
import Rkc.Stack.StaticStack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DynamicStack<String> stack = new DynamicStack<String>();
        System.out.println(stack.isEmpty());

        String[] itens = new String[6];
        itens[0] = "A";
        itens[1] = "B";
        itens[2] = "C";
        itens[3] = "E";
        itens[4] = "F";
        itens[5] = "G";


        stack.pushRange(itens);

        System.out.println(stack.currentSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.currentSize());
        System.out.println(stack.pop());
        System.out.println(stack.currentSize());
        stack.clear();
        System.out.println(stack.isEmpty());
        System.out.println(stack.currentSize());

    }
}