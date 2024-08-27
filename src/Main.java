import Rkc.List.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<String>();
        System.out.println(queue.isEmpty());

        queue.add("A"); //1
        queue.add("B"); //2
        queue.add("C"); //3
        queue.add("D"); //4
        queue.add("E", 0); //0
        queue.add("F", 2);
        queue.add("G");
        queue.add("H");
        queue.remove(0);
        queue.remove(queue.getSize()-1);
        queue.remove(queue.getSize()-2);
        queue.remove(100000);

        System.out.println(queue.isEmpty());
    }
}