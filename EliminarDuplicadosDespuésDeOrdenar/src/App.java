import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
      
        BubbleSort sorting = new BubbleSort();
        int[] arr = {4, 2, 9, 2, 4, 7, 1};
        System.out.println("Arreglo original");
        System.out.println(Arrays.toString(arr));
        sorting.sort(arr);

        int[] nuevoArreglo = sorting.eliminarDuplicados(arr);


        System.out.println("Arreglo sin duplicado y ordenado: " );
        System.out.println( Arrays.toString(nuevoArreglo));
    }
}
