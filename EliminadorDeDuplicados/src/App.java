public class App {
    public static void main(String[] args) throws Exception {

        SinglyLinkedList lista = new SinglyLinkedList();
        lista.add(2);
        lista.add(1);
        lista.add(2);
        lista.add(1);
        lista.add(3);
        lista.add(4);
        System.out.println("=======Lista===");
        lista.printList();
        System.out.println("=======Lista sin duplicados======");
        lista.removeDuplicates();
        lista.printList();
    }
}
