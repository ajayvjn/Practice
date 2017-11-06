package concepts;

/**
 * Created by Ajay on 10/24/17.
 */
public class StringInsertionForPalindrome {

    public static void main(String[] args) {
        String str = "abcdcb";

        System.out.println(new StringInsertionForPalindrome().countRecursive(str.toCharArray(), 0, str.length()-1));
    }

    private int countRecursive(char[] str, int l, int h) {

        if (l > h) return -1;
        if (l == h) return 0;
        if (l == h-1) return str[l] == str[h]? 0 : 1;

        int count = -1;
        if (str[l] == str[h]){
            count = countRecursive(str, l+1, h-1);
        } else {
            count = Math.min(countRecursive(str, l, h-1), countRecursive(str, l+1, h)) + 1;
        }
        return count;
    }
}
