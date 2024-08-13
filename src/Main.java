import Rkc.Queue.DynamicQueue;
import Rkc.Queue.StaticQueue;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DynamicQueue<String> queue = new DynamicQueue<String>();
        System.out.println(queue.isEmpty());

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("E");
        queue.add("F");
        queue.add("G");
        queue.add("H");

        System.out.println(queue.isEmpty());
        String removed = queue.remove();
        removed = queue.remove();
        removed = queue.remove();
        removed = queue.remove();
        removed = queue.remove();

        System.out.println(removed);
        System.out.println(queue.isEmpty());

    }
}