package concepts;

/**
 * Created by Ajay on 8/29/17.
 */
public class BitOperations {
    public static void main(String[] args) {


        System.out.println(1^2^2^1^6);

        /*
            left rotation
         */
        System.out.println(1<<8);   // 2 ^ 8


        /*
            rotate bits preserving the lost bits (circular shift).
            0xABCDEF12 => 0x12ABCDEF

            0xABCDEF12 >> 2 = 0x00ABCDEF
            0xABCDEF12 << (32 - 2) = 0x12000000

            OR both the results to get the answer

            Works for both types for rotation.
         */

        int x = 34;
        int rotate = 2;

        int result = x >> rotate | x << (32-rotate);

    }
}
