public class DoubleLinkedList {

    Node head;
    Node tail;

    public void add(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;

        tail = newNode;
    }
    public void printForward(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current);
    }

    public void printBackward(){

        Node current = head;
        while (current.next != null) {
            
            current = current.next;

        }
        while (current != null) {
            System.out.println(current.data);

            current = current.prev;

        }
        System.out.println(current);

    }

public void remove(int data){
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Valor no encontrado");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        if (current.next != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        } 
    
        else {
            current.prev.next = null;
            tail = current.prev; 
        }
    }  

}
