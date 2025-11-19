import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        InsertionSort sorting = new InsertionSort();
        double[] arrTemperaturas = {10.5,13.6,12.3,10.8,22.2};
         System.out.println("Arreglo original");
        System.out.println(Arrays.toString(arrTemperaturas));

        System.out.println("Arreglo ordenado");
        sorting.sort(arrTemperaturas);

        double temperaturaMinima = arrTemperaturas[0];
        double temperaturaMaxima = arrTemperaturas[arrTemperaturas.length -1];

        System.out.println("Temperatura minimma: " + temperaturaMaxima);
        System.out.println("Temperatura maxima: " + temperaturaMinima);
        System.out.println("Rango: " + (temperaturaMaxima - temperaturaMinima));


        System.out.println("top 3 Bajas ");
        for (int i = 0; i < arrTemperaturas.length; i++) {
            if (i < 3) {
                System.out.println(arrTemperaturas[i]);
            }
            
        }
        System.out.println("top 3 altas ");
        int posicion = 0 ;
        int n = arrTemperaturas.length;
        for (int i = n - 1; i >= 0 && posicion < 3;i--) {
            System.out.println(arrTemperaturas[i]);
            posicion++;
        }
    }
}
