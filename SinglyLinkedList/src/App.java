public class App {
    public static void main(String[] args) throws Exception {

        SinglyLinkedList lista = new SinglyLinkedList();
        lista.printList();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(5);
        lista.add(1);
        System.out.println("==============");
        lista.printList();
        lista.remove(5);
        System.out.println("==============");
        lista.printList();
        System.out.println("==============");
        System.out.println(lista.numberOccurrences(1));
    }
}
