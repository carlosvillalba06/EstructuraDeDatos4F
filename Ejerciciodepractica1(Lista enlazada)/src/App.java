public class App {
    public static void main(String[] args) throws Exception {
    SinglyLinkedList listaOriginal = new SinglyLinkedList();
    listaOriginal.add(1);
    listaOriginal.add(2);
    listaOriginal.add(3);
    listaOriginal.add(4);
    listaOriginal.add(5);
    listaOriginal.add(6);

    System.out.println("======Lista Original=========");
    listaOriginal.printList();

    SinglyLinkedList pares = new SinglyLinkedList();
    SinglyLinkedList impares = new SinglyLinkedList();

    Node current = listaOriginal.head;
        while (current != null) {
            if (current.data % 2 == 0) {
                pares.add(current.data);
            }else{
                impares.add(current.data);
            }
            current = current.next;
        }

    System.out.println("========Lista pares=====");
    pares.printList();
    System.out.println("========Lista impares===");
    impares.printList();
    
    }
}
