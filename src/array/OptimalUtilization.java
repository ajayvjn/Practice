package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*

Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id
and the second integer represents a value.
Your task is to find an element from a and an element form b such that the sum of their values is less
or equal to target and as close to target as possible. Return a list of ids of selected elements.
If no pair is possible, return an empty list.

        Example 1:

        Input:
        a = [[1, 2], [2, 4], [3, 6]]
        b = [[1, 2]]
        target = 7

        Output: [[2, 1]]

        Explanation:
        There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
        Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
*/


public class OptimalUtilization {

    public static void main(String[] args) {
        OptimalUtilization main = new OptimalUtilization();
        int[] maxTravelDists = {7000, 10000, 10000};
        int[][][] forwardRouteLists = {{{1, 2000}, {2, 4000}, {3, 6000}},
                {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
                {{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}}};
        int[][][] returnRouteLists = {{{1, 2000}},
                {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
                {{1, 2000}, {2, 2000}, {3, 4000}, {4, 4000}}};

        for (int i = 0; i < maxTravelDists.length; ++i) {
            List<int[]> l = main.optimalUtilization(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]);
            for (int[] m : l) {
                System.out.print(Arrays.toString(m));
            }
            System.out.println();

        }
    }

    private List<int[]> optimalUtilization(int target, int[][] a, int[][] b) {
        //Arrays.sort(a, (i, j) -> i[1] - j[1]);
        Arrays.sort(a, Comparator.comparingInt(i -> i[1]));
        Arrays.sort(b, (i, j) -> j[1] - i[1]);
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        List<int[]> l = new ArrayList<>();
        while (i < a.length && j < b.length) {
            int x = a[i][1];
            int y = b[j][1];
            int sum = x + y;
            if (sum > target) {
                j++;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        l.clear();
                    }
                    l.add(new int[]{a[i][0], b[j][0]});
                    int t = j + 1;
                    while (t <= b.length - 1 && b[t - 1][1] == b[t][1]) {
                        l.add(new int[]{a[i][0], b[t++][0]});
                    }
                }
                i++;
            }
        }
        return l;
    }
}
