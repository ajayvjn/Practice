package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePair {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 1, 2, 45, 46, 46};
        int target1 = 47;
        int[] test2 = new int[]{5, 5, 1, 5, 6,4,6};
        int result = getUniquePairs1(test2,10);
        System.out.print(result);
    }

    public static int getUniquePairs1(int[] nums, int target){
        Set<Integer> seen =  new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums){
            if (map.containsKey(num)){
                int key = map.get(num);
                if (! seen.contains(key)){
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target-num, num);
            }
        }
        return ans;


    }

    public static int getUniquePairs2(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int count = 0;
        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!set.contains(num)){
                set.add(num);
            }

        }

        return count;
    }
}
