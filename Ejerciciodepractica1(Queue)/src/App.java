public class App {
    public static void main(String[] args) throws Exception {
       ArrayQueue<Customer> queue = new ArrayQueue<>();
       queue.offer(new Customer(1, "Carlos"));
       queue.offer(new Customer(2, "Naul"));
       queue.offer(new Customer(3, "Cano"));

       int elementBefore = queue.getSize();
       System.out.println("Lista sin invertir");
       queue.print();
    
       int elementAfter = queue.getSize();
       System.out.println("Lista invertida");
       queue.reverse();
       queue.print();

       System.out.println("Elementos antes: " + elementBefore + "Elementos despues: " + elementAfter);
    }
}
