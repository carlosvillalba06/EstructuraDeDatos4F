public class BinarySearchTree {

    Node root;

    public void insert (int value){
        root = insertRecursive(root, value);

    }


    private Node insertRecursive(Node current, int value){


        //caso base, cuando current sea null, en este punto vamos a crear el node
        if(current == null){
            return new Node(value);
        }

        //si el valor a insertar es menor que el valor de current
        //Entonces vamos a crear ek nodo del lado izquierdo

        if(value < current.value){
            current.left = insertRecursive(current.left, value);

            //Si el valor a insertar es mayor que el valor de current
            //Vamos a crear el nodo de lado derecho
        }else if(value > current.value){
            current.right = insertRecursive(current.right, value);
        }

        //En caso de ser numero iguales, no se hace nada (para este caso)
        //Pero podrias decidir si lo dejas en el mismo nodo o no

        return current;
    }

    public void printInOrder(){
        System.out.println("---- Print in Order ----");
        printInOrderRecursive(root);

    }

    private void printInOrderRecursive(Node current){
        if(current != null){
            //Recorrido del lado izquierdo
            printInOrderRecursive(current.left);
            System.out.println(current.value + " ");
            printInOrderRecursive(current.right);
        }
    }
}