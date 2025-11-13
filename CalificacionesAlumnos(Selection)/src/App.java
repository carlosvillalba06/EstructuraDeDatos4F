import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        SelectionSort sorting = new SelectionSort();
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuantas calificaciones deseas registrar?");
        int cantidad = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[cantidad];
        Double[] calificaciones = new Double[cantidad];

        System.out.println("==ingresa los nombre==");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre [" + (i+1) + "] -> ");
            nombres[i] = sc.nextLine();
        }
        System.out.println("==Ingrese las calificaciones==");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese la calificacion [" + (i+1) + "] -> ");
            calificaciones[i] = sc.nextDouble();
            sc.nextLine();
        }

        sorting.sort(nombres, calificaciones);
        System.out.println("Nombres y calificaciones ");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println(calificaciones[i] + " " + nombres[i]);
            
        }

    }
}
