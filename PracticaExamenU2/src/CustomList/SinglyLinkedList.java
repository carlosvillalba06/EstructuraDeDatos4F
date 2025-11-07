package CustomList;

import Model.JobCustom;

public class SinglyLinkedList {

    private Node head;

    
    public void add(JobCustom data) {
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

    
    public void remove(JobCustom data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null)
            current.next = current.next.next;
    }

    
    public JobCustom removeLast() {
        if (head == null) return null;

        if (head.next == null) {
            JobCustom value = head.data;
            head = null;
            return value;
        }

        Node current = head;
        while (current.next.next != null) { 
            current = current.next;
        }

        JobCustom value = current.next.data;
        current.next = null; 
        return value;
    }

    
    public boolean isEmpty() {
        return head == null;
    }

  
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("Null");
    }
}