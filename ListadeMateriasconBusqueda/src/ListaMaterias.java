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

}
