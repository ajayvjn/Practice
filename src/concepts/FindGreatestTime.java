package concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ajay on 2/14/17.
 */
public class FindGreatestTime {

    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println(solution(1,8,3,2));

    }

    public static String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        getAllCombinations(new int[]{A,B,C,D}, 0);
        if(list.size() == 0){
            return "NOT POSSIBLE";
        }
        Collections.sort(list);
        String numStr = String.format("%04d", list.get(list.size()-1));
        return numStr.substring(0,2) + ":" + numStr.substring(2);
    }

    public static void getAllCombinations(int[] arr, int index)
    {
        if (index == arr.length)
        {
            StringBuilder numStr = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
            {
                numStr.append(arr[i]);
            }
            int num = Integer.parseInt(numStr.toString());
            if (num < 2400 && num%100<60) {
                list.add(num);
            }
        }
        else
        {
            for (int i = index; i < arr.length; i++)
            {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                getAllCombinations(arr, index + 1);

                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
