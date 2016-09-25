package Sorting;

import java.util.Arrays;

/**
 * Created by Ajay on 18-Sep-16.
 * Selection Sort
 */
public class SelectionSort {

    public static void main(String[] args) {
        int a[] = {5, 2, 5, 3, 8, 6, 9};
        new SelectionSort().doSort(a);
        System.out.println(Arrays.toString(a));
    }

    private void doSort(int[] a) {
        int min;
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}
