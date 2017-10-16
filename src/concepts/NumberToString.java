package concepts;

/**
 * Created by Ajay on 10/16/17.
 */
public class NumberToString {

    public static final String[] LESS_THAN_20 = new String[]{
            "", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine","Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] LESS_THAN_100 = new String[]{
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};
    public static final String[] OTHER = new String[]{
            "", "Thousand", "Million", "Billion"};


    private String convert(long num) {
        if (num == 0) return "Zero";

        int index = 0;
        String s = "";

        while (num!=0){
            if (num % 1000 != 0) {
                long n = num % 1000;
                s = generateString((int)n) + OTHER[index++] + " " + s;
            }
            num = num /1000;
        }
        return s;
    }

    private String generateString(int n) {
        if (n < 20){
            return LESS_THAN_20[n] + " ";
        } else if (n < 100) {
            return LESS_THAN_100[n/10] + " " + generateString(n % 10);
        } else {
            return LESS_THAN_20[n/100] + " Hundred " + generateString(n % 100);
        }
    }

    public static void main(String[] args) {
        long num = 987766554321l;
        System.out.println(new NumberToString().convert(num));
    }
}
