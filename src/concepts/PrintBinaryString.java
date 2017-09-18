package concepts;

import java.util.Arrays;

/**
 * Created by Ajay on 9/17/17.
 */
public class PrintBinaryString {

    static int A[] = null;

    public static void main(String[] args) {
        int i = 5;
        A = new int[i];
        new PrintBinaryString().binary(i);
    }

    private void binary(int i) {
        if (i < 1){
            System.out.println(Arrays.toString(A));
        } else {
            A[i-1] = 0;
            binary(i-1);
            A[i-1] = 1;
            binary(i-1);
        }
    }
}
