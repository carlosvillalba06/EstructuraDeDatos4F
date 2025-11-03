public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            
            current = current.next;
        }
        current.next = newNode;
    }

     public Boolean contains(int data){
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
            
        }

        return false;
    }

    public void remove(int data){

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public void printList(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }

        System.out.println("Null");
    }
}
