package concepts;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Ajay on 10/24/17.
 *
 *  find the minimum number of characters to remove from a string to create a valid string.
 *
 *  QUESTIONS:
 *      What to do if nothing matches with the dict?
 *
 */
public class StringDeletionToMatchDict {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        String str = "abc";

        System.out.println(new StringDeletionToMatchDict().deleteStringCount(str, dict));
    }

    private int deleteStringCount(String str, Set<String> dict) {

        Queue<String> q = new LinkedList<>();
        Set<String> elements = new HashSet<>();

        q.add(str);
        elements.add(str);

        while (!q.isEmpty()){
            String s = q.poll();
            elements.remove(s);

            if (dict.contains(s)) return str.length() - s.length();

            for (int i = 0; i < s.length(); i++){
                String tmp = s.substring(0, i) + s.substring(i+1, s.length());
                if (!elements.contains(tmp) && tmp.length() > 0){
                    q.add(tmp);
                    elements.add(tmp);
                }
            }
        }

        return -1;
    }
}
