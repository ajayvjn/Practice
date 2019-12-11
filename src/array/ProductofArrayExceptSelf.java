package array;

import java.util.Arrays;

/**
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 */
public class ProductofArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    private static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) { // bad input
            return null;
        }
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < L.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[R.length - 1] = 1;
        for (int i = R.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
