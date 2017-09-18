import java.util.*;
import java.lang.*;

class Demo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        System.out.println("hiiii");

        for(int i=0; i<n; i++){
            flag = false;
            String a_str = sc.nextLine();a_str =sc.nextLine();
            System.out.println(a_str);
            String a[] = a_str.split(" ");

            int a_int[] = { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };

            String b_str = sc.nextLine();
            b_str = sc.nextLine();
            String b[] = b_str.split(" ");

            int b_int[] = new int[a_int[0]];

            for(int j=0; j<a_int[0]; j++){
                b_int[j] = Integer.parseInt(b[j]);
                if(b_int[j]==a_int[1])
                    flag = true;
            }

            if(flag){
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }

        }
    }
}