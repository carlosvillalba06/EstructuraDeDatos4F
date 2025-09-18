import java.util.ArrayDeque;
import java.util.Deque;

public class Historial{

    public static void main(String[] args) {
        Deque<String> paginas = new ArrayDeque<>();
        
        paginas.push("https://Google.com");
        paginas.push("https://Facebook.com");
        paginas.push("https://Youtube.com");

        System.out.println("Historial actual:  ");
        for(String pagina: paginas){
            System.out.println(pagina);
        }
        System.out.println("\nRetrocede una pagina: " + paginas.pop());
        System.out.println("\nPagina actual: " + paginas.peek());

        System.out.println("\nAgrego nueva pagina: https://Classroom.com ");
        paginas.push("https://Classroom.com");

        System.out.println("\nContenido de toda la pila");
        for(String pagina: paginas){
            System.out.println(pagina);
        }
    

    }




}
