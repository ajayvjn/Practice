package concepts;


import java.util.HashMap;

/**
 * Created by Ajay on 1/30/17.
 */
public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "Ajay";
        str = str.toLowerCase();

        NonRepeatingCharacter nrc = new NonRepeatingCharacter();
        nrc.method1(str);
        nrc.method2(str);
    }

    private void method1(String str) {

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.println("Non Repeating Character = " + c);
                break;
            }
        }
    }

    private void method2(String str) {
        HashMap<Character, Integer> characterHM = new HashMap<Character, Integer>();
        char c = 'a';

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (characterHM.containsKey(c)) {
                // remove the character from hash map
                characterHM.remove(c);
            } else {
                characterHM.put(c, 1);
            }
        }

        if (characterHM.size() > 0) {
            //get the first key as it is the first non repeated char.
            c = characterHM.keySet().iterator().next();
            System.out.println("Non Repeating Character = " + c);
        }
    }
}
