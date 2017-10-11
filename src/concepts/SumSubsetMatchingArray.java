package concepts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ajay on 10/3/17.
 */
public class SumSubsetMatchingArray {

    static ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();


    static void sum(int[] arr, int i, int sum, int target, ArrayList<Integer> arrList) {
        for (int j = i + 1; j < arr.length; j++) {
            if(sum + arr[j] > target) {
                continue;           // break when array is sorted
            } else if (sum + arr[j] == target) {
                arrList.add(arr[j]);
                list.add(arrList);
            } else {
                ArrayList<Integer> cloneList = (ArrayList<Integer>) arrList.clone();
                cloneList.add(arr[j]);
                sum(arr, j, sum + arr[j], target, cloneList);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {6, 3, 8, 10, 1};

        for (int i = 0; i < numbers.length; i++) {
            ArrayList<Integer> arr= new ArrayList<Integer>();
            arr.add(numbers[i]);
            sum(numbers, i, numbers[i], 18, arr);
        }

        for (ArrayList<Integer> l: list){
            System.out.println(Arrays.toString(l.toArray()));
        }

    }


    /*static void sum(int[] arr, int i, int sum, int target, String s) {
        for (int j = i + 1; j < arr.length; j++) {
            if (sum + arr[j] == target) {
                System.out.println(s + " " + String.valueOf(arr[j]));
            } else {
                sum(arr, j, sum + arr[j], target, s + " " + String.valueOf(arr[j]));
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {6, 3, 8, 10, 1};
        for (int i = 0; i < numbers.length; i++) {
            sum(numbers, i, numbers[i], 18, String.valueOf(numbers[i]));
        }

    }*/
}
