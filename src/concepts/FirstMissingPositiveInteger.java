package concepts;

/**
 * Created by Ajay on 11/6/17.
 */
public class FirstMissingPositiveInteger {

    public static void findMinMissing(int[] arr) {
        //Move -ve number to end of array either shift or just remove
        int ctr = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > 0) {
                arr[ctr] = arr[i];
                ctr++;
            }
        }

        int maxEndLength = ctr; // max length of positive numbers

        //Mark kth index where k=arr[i]  and is in array's range
        //Since +ve numbers start from 1 and array index from 0, we mark k-1 index as negative

        for (int i = 0; i < maxEndLength; i++) {
            int index = Math.abs(arr[i]) - 1; // minus 1, element may be marked negative so check abs value
            if (index <= maxEndLength-1) {
                arr[index] = -1 * arr[index];
            }
        }

        //find the first missing positive number
        int firstMissingValue = 0;
        for (int i = 0; i < maxEndLength; i++) {
            if (arr[i] > 0) {
                firstMissingValue = i + 1; // since we subtracted 1
                break;
            }
        }

        System.out.println("Missing value = " + firstMissingValue);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 9, -3, 2, 5, 7};
        findMinMissing(arr);
    }
}
