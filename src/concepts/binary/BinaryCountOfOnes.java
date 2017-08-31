package concepts.binary;

/**
 * Created by Ajay on 8/30/17.
 */
public class BinaryCountOfOnes {
    public static void main(String[] args) {
        System.out.println(ones(7));
    }

    private static int ones(int i) {
        int sum = 0;

        while (i > 0){
            sum += i & 1;
            System.out.println(i >> 1);
            i >>= 1;
        }
        return sum;
    }
}
