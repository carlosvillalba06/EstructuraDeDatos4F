import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        Boolean swapped = false;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temporal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporal;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        System.out.println("Arreglo ordenado");
        System.out.println(Arrays.toString(arr));
    }

    public int[] eliminarDuplicados(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int[] temp = new int[arr.length];
        int index = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[index] = arr[i];
                index++;
            }
        }

        temp[index] = arr[arr.length - 1];
        index++;

        int[] arregloResultado = new int[index];

        for (int i = 0; i < index; i++) {
            arregloResultado[i] = temp[i];
        }

        return arregloResultado;
    }
}
