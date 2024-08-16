import Rkc.Queue.CircleQueue;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CircleQueue<String> queue = new CircleQueue<String>(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("E");
        queue.add("F");


        queue.remove();
        queue.remove();

        queue.add("G");
        queue.remove();
        queue.add("G");

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }
}