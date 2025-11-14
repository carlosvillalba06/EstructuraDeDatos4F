import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        QuickSort sorting = new QuickSort();

        int[] arr = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
        sorting.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
