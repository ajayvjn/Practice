package concepts;

/**
 * Created by Ajay on 27-Jun-16.
 */
public class SecondHighest {
    static int secondHighest(int... nums) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > high1) {
                high2 = high1;
                high1 = num;
            } else if (num > high2 && num < high1) {
                high2 = num;
            }
        }
        return high2;
    }

    public static void main(String[] args) {
        int a[] = {1,0};
        System.out.println(secondHighest(a));
    }
}
