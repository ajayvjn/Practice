package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ajay on 8/28/17.
 *
 * QUESTIONS
 *  Type of input
 *  Format of Input
 *  Format of output
 */
public class PermutationsGeneric {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        List<int[]> list = permute(numbers);
        for (int[] a: list){
            System.out.println(Arrays.toString(a));
        }
    }

    private static List<int[]> permute(int[] numbers) {
        List<int[]> list = new ArrayList<int[]>();
        permute(numbers, 0, list);
        return list;
    }

    private static void permute(int[] numbers, int start, List<int[]> list) {
        if(start >= numbers.length) {
            // Important to clone the array as we are using reference here and it is modified in future.
            list.add(numbers.clone());
        } else {
            for (int i = start; i < numbers.length; i++) {
                swap(numbers, start, i);
                permute(numbers, start + 1, list);
                // swapping it back so that the array is unchanged.
                swap(numbers, start, i);
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
