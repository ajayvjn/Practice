package concepts;

/**
 * Created by Ajay on 8/28/17.
 *
 * QUESTIONS
 *  Length of the strength - whether caching required or not.
 *  How to treat multiple max strings
 */

public class LongestSubstring2StringsCache {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "bcd";
        System.out.println(subString(a,b));
    }

    private static String subString(String a, String b) {

        String str = "";

        if (a.length() == 0 || b.length() == 0)
            return str;

        int[][] cache = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)){
                    if (i == 0 || j == 0){
                        cache[i][j] = 1;
                    } else {
                        cache[i][j] = cache[i-1][j-1] + 1;
                    }

                    if(str.length() < a.substring(i - cache[i][j] + 1, i + 1).length())
                        str = a.substring(i - cache[i][j] + 1, i + 1);
                }
            }
        }
        return str;
    }
}
