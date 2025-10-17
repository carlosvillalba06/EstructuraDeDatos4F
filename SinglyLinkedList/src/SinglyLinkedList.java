public class SinglyLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);//Creación de un nuevo nodo
        if (head == null) {//Verficación de lista vacia
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {//Recorrido de los nodos, hasta encontrar el ultimo
            
            current = current.next;
        }

        current.next = newNode;//Insertar nuevo nodo al final de la lista
    }

    public Boolean contains(int data){
        /*if (head == null) {
            System.out.println("La lista esta vacia.");
            return false;
        }*/

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

        if (head == null) {//Pregunta si la lista esta vacia
            return;
        }

        if (head.data == data) {//Valida que el dato este en el head
            head = head.next;//Elimina el primer nodo
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != data) {//Recorrer hasta encontrar
            current = current.next;
        }

        current.next = current.next.next;//ASignamos el nodo corriente al siguiente
    }

    public void printList(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        System.out.println("Null");
    }


    public int numberOccurrences(int data){

        int contador = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                contador++;
            }
            current = current.next;
        }
        return contador;
    }
}
