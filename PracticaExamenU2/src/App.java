import java.util.Scanner;


import CustomList.SinglyLinkedList;
import CustomQueue.ArrayQueue;
import CustomStack.ArrayStack;
import Model.JobCustom;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayQueue<JobCustom> queue = new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList lista = new SinglyLinkedList();

        System.out.println("Comandos: ADD, PROCESS, COMMIT, PRINT, END");
        System.out.println("Ingresa comandos....");
        while (true) {
            System.out.print("->");
            String comando = sc.nextLine().toUpperCase();
            switch (comando) {
                case "ADD":
                    System.out.print("Id: ");
                    String id = sc.nextLine();
                    queue.offer(new JobCustom(id));
                    break;

                case "PROCESS":
                    System.out.print("Cantidad a procesar: ");
                    int num = Integer.parseInt(sc.nextLine()) ;
                    int cont = 0;
                    
                    while (!queue.isEmpty() && cont<num) {
                       JobCustom job = (JobCustom) queue.poll(); 
                       if (job == null) break; 
                       stack.push(job);
                       cont++;
                    }
                    break;
                
                case "COMMIT":
                    while (!stack.isEmpty()) {
                        lista.add(stack.pop());
                    }
                    break;

                case "ROLLBACK":
                     System.out.print("Cantidad a revertir: ");
                    int m;
                    try {
                        m = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Número inválido.");
                        break;
                    }
                    int revertidos = 0;
                    while (!lista.isEmpty() && revertidos < m) {
                        JobCustom job = lista.removeLast();
                        if (job == null) break;
                        queue.offer(job);
                        revertidos++;
                    }

                    break;
                
                case "PRINT":
                
                    printData(queue,stack,lista);
                    break;
                case "END":
                    System.out.println("====Estado final====");
                    printData(queue,stack,lista);
                    return;
            
                default:
                    System.out.println("Comando no reconocido");
                    break;
            }

        }





    }

    public static void printData(ArrayQueue<JobCustom> queue,ArrayStack<JobCustom> stack, SinglyLinkedList lista){
        System.out.println("Queue");
        queue.print();
        System.out.println("Stack");
        stack.print();
        System.out.println("Lista");
        lista.printList();
    }
}
