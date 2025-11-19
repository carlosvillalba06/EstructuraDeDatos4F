import java.util.Arrays;

public class InsertionSort {

    public void sort(double[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            double temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j]>temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
