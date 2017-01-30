package sorting;

import java.util.Arrays;

/**
 * Created by Ajay on 18-Sep-16.
 * Insertion Sort
 */
public class InsertionSort {

    public static void main(String[] args) {
        int a[] = {5, 2, 5, 8, 6, 3, 9};
        new InsertionSort().doSort(a);
        System.out.println(Arrays.toString(a));
    }

    private void doSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
