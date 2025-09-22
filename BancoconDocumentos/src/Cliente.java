import java.util.ArrayDeque;
import java.util.Deque;

public class Cliente {

    int id;
    String nombre;
    Deque<String> documentos;


    public Cliente(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        documentos = new ArrayDeque<>();
    }   


    public void agregarDocumento(String doc){
        documentos.push(doc);
    }

    public void next(){

        while (!documentos.isEmpty()) {

            System.out.println("Documento retirado: " + documentos.pop());
            
        }
    }

    @Override
    public String toString(){
        return nombre;
    }
}
