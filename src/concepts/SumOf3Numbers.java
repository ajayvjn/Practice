package concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ajay on 9/1/17.
 *
 * QUESTIONS
 *  Are all the numbers in the given list unique
 *  Is the list sorted
 *  Can the output contain duplicates
 */
public class SumOf3Numbers {
    public static void main(String[] args) {
        int[] n = {-1,-1,2,-4,-1, -1,  2};
        List<int[]> list = sum(n);
        for (int[] a: list){
            System.out.println(Arrays.toString(a));
        }
    }

    private static List<int[]> sum(int[] n) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(n);

        for (int i = 0; i < n.length - 2; i++) {
            if(i==0 || n[i] > n[i-1]){
                int start = i+1;
                int end = n.length -1;

                while (start<end){
                    if (n[i] + n[start]+ n[end] == 0){
                        result.add(new int[]{n[i], n[start], n[end]});
                    }

                    if (n[i] + n[start]+ n[end] < 0){
                        int currentStart = start;
                        while (n[start] == n[currentStart] && start<end){
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while (n[end] == n[currentEnd] && start<end){
                            end--;
                        }
                    }
                }
            }
        }

        return result;
    }
}
