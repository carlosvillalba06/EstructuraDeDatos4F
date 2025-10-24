import java.util.ArrayDeque;
import java.util.Queue;

public class App {

    public static void main(String[] args) throws Exception {

        Queue<Cliente> queue = new ArrayDeque<>();

        Cliente c1 = new Cliente(1, "Juanito");
        c1.agregarDocumento("Doc 1");
        c1.agregarDocumento("Doc 2");

        Cliente c2 = new Cliente(2, "Juanita");
        c2.agregarDocumento("Doc 1");
        c2.agregarDocumento("Doc 2");

        Cliente c3 =  new Cliente(3,"Pedro");
        c3.agregarDocumento("Doc 1");
        c3.agregarDocumento("Doc 2");
        queue.offer(c1);
        queue.offer(c2);
        queue.offer(c3);
        while (!queue.isEmpty()) {
            Cliente clienteAcutual = queue.peek();
            System.out.println("Cliente en atencion:  " + clienteAcutual);
            clienteAcutual = queue.poll();
            clienteAcutual.next();
            if (!queue.isEmpty()) {
                System.out.println("Cola restante: " + queue);
            }   
        }        
    }
}
