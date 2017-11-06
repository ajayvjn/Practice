package concepts;

import java.util.Arrays;

/**
 * Created by Ajay on 10/16/17.
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println(new LongestSubsequence().lengthOfLIS(A));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; // initialized as Integer.MIN_VALUE
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++; //when x is the greatest by far
        }
        return len;
    }
}
