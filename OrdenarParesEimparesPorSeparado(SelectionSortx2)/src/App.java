import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      SelectionSort sorting = new SelectionSort();
      Scanner sc = new Scanner(System.in);
      System.out.print("Cuantos numeros deseas ingresar? ");
      int cantidad = sc.nextInt();
      sc.nextLine();

      int[] arregloCompleto = new int[cantidad];
      int pares = 0;
      int impares = 0;

      for (int i = 0; i < arregloCompleto.length; i++) {
        System.out.print("Numero [" + (i + 1)+"] -> ");
        arregloCompleto[i] = sc.nextInt();
        
      }

      for (int i : arregloCompleto) {
        if (i %  2 == 0) {
            pares++;
        }else{
            impares++;
        }
      }
      int[] arrPar = new int[pares];
      int[] arrImpar = new int[impares];

      int indexP = 0;
      int indexI = 0;

      for (int i = 0; i < arregloCompleto.length; i++) {
        if (arregloCompleto[i] % 2 == 0) {
            arrPar[indexP++] = arregloCompleto[i];
        }else{
            arrImpar[indexI++] = arregloCompleto[i];
        }
      }
      System.out.println("Arreglo original  ");
      System.out.println(Arrays.toString(arregloCompleto));
      System.out.println("Arreglo impares ordenados ");
      sorting.sort(arrImpar);
      System.out.println("Arreglo pares ordenados ");
      sorting.sort(arrPar);
    }
}
