public class App {
    public static void main(String[] args) throws Exception {
        ArrayStack<Character> stack1 = new ArrayStack<>();
        System.out.println("Inicio");
        stack1.print();
        stack1.push('A');
        stack1.push('B');
        stack1.push('C');
        System.out.println("stack con elementos");
        stack1.print();
        stack1.pop();
        System.out.println("con pop");
        stack1.print();
        System.out.println("Llamar a la funcion clear");
        stack1.clear();
        stack1.print();
           
    }
}
