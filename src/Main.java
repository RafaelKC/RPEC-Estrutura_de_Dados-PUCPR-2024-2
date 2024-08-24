import Rkc.List.StaticList;

public class Main {
    public static void main(String[] args) {
        StaticList<String> queue = new StaticList<String>(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        queue.add("G");
        queue.add("G", 0);
        queue.add("G");
        queue.add("G");
        queue.add("G");
        queue.remove(0);
        queue.add("G");

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }
}