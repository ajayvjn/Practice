package algorithms;

/**
 * Kadane's Algorithm
 * Maximum Sum Subarray Problem - O(n)
 *
 * This algorithm handles all cases including all negative numbers in an array.
 *
 * Created by Ajay on 2/24/17.
 */
public class Kadane {
    public static void main(String[] args) {
        int arr[] = {1, -1, -2, 3, 1, -1, 2};
        System.out.println("---KADANE'S ALGORITHM---");

        // Max Sum Subarray without index
        getMaxSubarray(arr);
    }

    private static void getMaxSubarray(int[] arr) {

        int maxSA = arr[0];
        int maxSATemp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSATemp = Math.max(maxSATemp + arr[i], arr[i]);
            maxSA = Math.max(maxSA, maxSATemp);
        }
        System.out.println("Max Sum Subarray: " + maxSA);
    }
}
