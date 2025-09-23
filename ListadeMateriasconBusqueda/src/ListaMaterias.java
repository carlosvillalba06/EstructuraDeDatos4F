import java.util.ArrayList;
import java.util.List;

public class ListaMaterias {

    private List<String> materias;

    public ListaMaterias(){
        materias = new ArrayList<>();
    }

    public void agregarMateria(String materia){

        materias.add(materia);
        
    }

    public boolean contiene(String materia){
        for (String mate : materias) {
            if (mate.equals(materia)) 
            {
                return true;
            }
            
        }

        return false;
    }



}
