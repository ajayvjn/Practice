package concepts;

/**
 * Created by Ajay on 8/28/17.
 */
public class LongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        //String str = "aabcdefba";
        String str = "ffabfcdefff";
        System.out.println(checkLongestSubstring(str));
    }

    private static String checkLongestSubstring(String s) {
        int[] cache = new int[128];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }

        int start_i = -1;
        int curr_i = -1;
        String substr = "";
        String substrTmp = "";

        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i)] == -1){
                cache[s.charAt(i)] = 1;
                if (start_i == -1 && curr_i == -1){
                    start_i = curr_i = i;
                } else {
                    curr_i = i;
                }
                substrTmp = s.substring(start_i, curr_i + 1);
                substr = substr.length() > substrTmp.length() ? substr : substrTmp;
            } else {
                start_i = i;
            }
        }
        return substr;
    }
}
