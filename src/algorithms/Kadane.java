package algorithms;

/**
 * Kadane's Algorithm
 * Maximum Sum Subarray Problem - O(n)
 * <p>
 * This algorithm handles all cases including all negative numbers in an array.
 * <p>
 * Created by Ajay on 2/24/17.
 */
public class Kadane {
    public static void main(String[] args) {
        int[] arr = {-4, 1, -1, -2, 3, 1, -1, 2};
        System.out.println("---KADANE'S ALGORITHM---");

        // Max Sum Subarray without index
        getMaxSubarray(arr);
        // Max Sum Subarray with index
        getMaxSubarrayWithIndex(arr);
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

    private static void getMaxSubarrayWithIndex(int[] arr) {
        int maxSA = arr[0];
        int maxSATemp = arr[0];

        int startIndex = 0;
        int endIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (maxSATemp + arr[i] < arr[i]) {
                endIndex = i;
                startIndex = i;
            }
            maxSATemp = Math.max(maxSATemp + arr[i], arr[i]);
            if (maxSA < maxSATemp) {
                endIndex = i;
            }
            maxSA = Math.max(maxSA, maxSATemp);
        }
        System.out.println("Max Sum Subarray: " + maxSA);
        System.out.println("startIndex: " + startIndex);
        System.out.println("endIndex: " + endIndex);
    }
}
