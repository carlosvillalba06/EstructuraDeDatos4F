import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        BubbleSort sorting = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuantos elementos deseas agregar? ");
        int cantidad = sc.nextInt();
        int[] arrOriginal = new int[cantidad];
        for (int i = 0; i < arrOriginal.length; i++) {
            System.out.print("Ingresa el valor [" + (i + 1) + "] - > ");
            arrOriginal[i] = sc.nextInt();
        }
        System.out.println("===Arreglo original===");
        System.out.println(Arrays.toString(arrOriginal));
        sorting.sort(arrOriginal);

        int primerElemento = arrOriginal[0];
        System.out.println("Valor minimo: " + primerElemento);

        int ultimoElemento = arrOriginal[arrOriginal.length - 1];
        System.out.println("Valor maximo: " + ultimoElemento);
        
        int diferencia = ultimoElemento - primerElemento;
        System.out.println("Diferencia: " + diferencia);

    }
}
