package concepts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 8/26/17.
 */
public class PermutationsString {
    public static void main(String[] args) {
        String str = "abc";
        PermutationsString p = new PermutationsString();
        List<String> result = p.permute(str);
        for(String a:result){
            System.out.println(a);
        }
    }

    private ArrayList<String> permute(String str) {
        ArrayList<String> result = new ArrayList<String>();
        permute("", str, result);
        return result;
    }

    private void permute(String prefix, String suffix, ArrayList<String> result){
        if(suffix.length() == 0){
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permute(prefix + suffix.charAt(i), suffix.substring(0,i)
                        + suffix.substring(i+1, suffix.length()), result);
            }
        }
    }
}
