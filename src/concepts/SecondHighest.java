package concepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Ajay on 27-Jun-16.
 */
public class SecondHighest {
    static int secondHighest(int... nums) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2 && num < high1) {
                high2 = num;
            }
        }
        return high2;
    }

    public static void main(String[] args) {
        int a[] = {1,0};
        System.out.println(secondHighest(a));


        PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Arrays.asList(queue.toArray());

    }
}
