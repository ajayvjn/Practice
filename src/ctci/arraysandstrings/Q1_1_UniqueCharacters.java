package ctci.arraysandstrings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ajay on 29-Sep-16.
 * Q: 1.1
 */
public class Q1_1_UniqueCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        boolean isUnique1 = findUniqueCharacters(str);
        System.out.println(isUnique1);
        boolean isUnique2 = findUniqueCharactersWithCollections(str);
        System.out.println(isUnique2);
    }

    private static boolean findUniqueCharacters(String str) {
        if (str.length() > 256)
            return false;
        boolean char_set[] = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (char_set[str.charAt(i)]) {
                return true;
            } else {
                char_set[str.charAt(i)] = true;
            }
        }
        return false;
    }

    private static boolean findUniqueCharactersWithCollections(String str) {
        if (str.length() > 256)
            return false;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
