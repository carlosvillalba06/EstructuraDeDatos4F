
public class SelectionSort {

    public void sort(String[] nombres, Double[] calificaciones){

        int n = calificaciones.length;

        for (int i = 0; i <  n-1; i++) {
            int minIndex = i; 
            for (int j = i + 1; j < n; j++) { 
                if (calificaciones[j] < calificaciones[minIndex]) {
                    minIndex = j;
                }
                
            }
        
            double calificacionTemp = calificaciones[minIndex];
            calificaciones[minIndex] = calificaciones[i];
            calificaciones[i] = calificacionTemp;

            String nombresTemp = nombres[minIndex];
            nombres[minIndex] = nombres[i];
            nombres[i] = nombresTemp;
        }
    }
}
