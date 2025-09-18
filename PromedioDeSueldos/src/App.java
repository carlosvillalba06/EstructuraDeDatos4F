import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        double suma = 0, promedio = 0;

        List<Worker> trabajadores = new ArrayList<>();

      
        trabajadores.add(new Worker(1, "Carlos", 2000.40));
        trabajadores.add(new Worker(2, "Ricardo", 3000.70));
        trabajadores.add(new Worker(3, "Pedro", 400.40));
        trabajadores.add(new Worker(4, "Getsai", 1500.40));
        trabajadores.add(new Worker(5, "Maximiliano", 700.40));
        trabajadores.add(new Worker(6, "Kevin", 600.40));

        for(Worker trabajador : trabajadores){
            System.out.println("ID: " + trabajador.getId() + " Nombre: " + trabajador.getNombre() + " Sueldo: " + trabajador.getSueldo());
            suma = suma + trabajador.getSueldo();
        }

        System.out.println(" ");
        promedio = suma / 6;
        System.out.println("Promedio de sueldos: " + promedio);
        int i = 0;
        while (i < trabajadores.size()){
            if(trabajadores.get(i).getSueldo() < 1000){
                trabajadores.remove(i);
            } else{
                i++;
            }
        }

        System.out.println(" ");

        for(Worker trabajador : trabajadores){

        System.out.println("ID: " + trabajador.getId() + " Nombre: " + trabajador.getNombre() + " Sueldo: " + trabajador.getSueldo());

    
        }

    
    }
}
