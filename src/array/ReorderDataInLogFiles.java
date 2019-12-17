package array;


/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
The digit-logs should be put in their original order.

Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
*/


import java.util.*;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = reorderLogFiles(logs);
        System.out.println(Arrays.toString(output));

    }

    private static String[] reorderLogFiles(String[] logs) {
        List<String> c = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for(int i = 0; i< logs.length; i++){
            String a = logs[i].split(" ", 2)[1];
            if(Character.isDigit(a.charAt(0))){
                digit.add(logs[i]);
            } else {
                c.add(logs[i]);
            }
        }

        c.sort((v1, v2) -> {
            int value = v1.substring(v1.indexOf(" ")+1).compareTo(v2.substring(v2.indexOf(" ")+1));
            if(value == 0){
                return v1.substring(0, v1.indexOf(" ")-1).compareTo(v2.substring(0,v2.indexOf(" ")-1));
            }
            return value;
        });

        c.addAll(digit);
        return c.toArray(new String[0]);
    }
}
