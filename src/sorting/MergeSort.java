package sorting;

import java.util.Arrays;

/**
 * Created by Ajay on 18-Sep-16.
 * Merge Sort
 */
public class MergeSort {

    private static int a[] = {5, 2, 5, 3, 8, 6, 9};
    private int tmp[] = new int[a.length];

    public static void main(String[] args) {
        new MergeSort().doSort(0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private void doSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            doSort(low, middle);
            doSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            tmp[i] = a[i];
        }
        int k = low;
        while (low <= middle && middle + 1 <= high) {
            if (tmp[low] < tmp[middle + 1]) {
                a[k++] = tmp[low++];
            } else {
                a[k++] = tmp[middle++ + 1];
            }
        }
        while (k <= middle) {
            a[low++] = tmp[k++];
        }
    }
}
