public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }

    public void printList(){
        Node current  = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("NULL");
    }


    public void removeDuplicates(){
        Node current = head;
        while (current != null) {
            Node currentTwo = current;
            while(currentTwo.next != null) {
                if (currentTwo.next.data == current.data) {
                    currentTwo.next = currentTwo.next.next;
                }else{
                    currentTwo = currentTwo.next;
                }
            }
                current = current.next;
            }
    }

}
