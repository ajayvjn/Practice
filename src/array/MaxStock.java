package array;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxStock {

    public static void main(String[] args) {
        // Returns max profit
        //System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        //System.out.println(maxProfit(new int[]{0, 6, -3, 7}));
        //System.out.println(maxProfit(new int[]{1, 3, 1, 2, 3}));

        // Returns 2 stock numbers
        System.out.println(Arrays.toString(maxProfitMinDays(new int[]{1, 3, 1, 2, 3})));
        System.out.println(Arrays.toString(maxProfitMinDays(new int[]{1, 2, 3, 1, 3})));
    }

    private static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private static int[] maxProfitMinDays(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int s = 0, e = 0;
        int smin = 0, emin = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                s = i;
                smin = s;
                emin = s;
            } else if (prices[i] == min) {
                s = i;
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
                e = i;
                emin = e;
            } else if (prices[i] - min == max) {
                if (emin-smin > i - s) {
                    smin = s;
                    emin = i;
                }
            }
        }

        return new int[]{smin, emin};
    }
}
