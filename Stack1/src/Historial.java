import java.util.ArrayDeque;
import java.util.Deque;

public class Historial{

    public static void main(String[] args) {
        Deque<String> paginas = new ArrayDeque<>();
        paginas.push("https://Google.com");
        paginas.push("https://Facebook.com");
        paginas.push("https://Youtube.com");

        for(String pagina: paginas){
            System.out.println(pagina);
        }

        System.out.println("Retrocede una pagina: " + paginas.pop());
        
        



    }




}
