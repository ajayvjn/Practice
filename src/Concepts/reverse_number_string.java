package Tricks;

public class reverse_number_string {

	public static void main(String[] args) {
		int number = 1234;
		int reverseNumber1 = reverse(number);
		int reverseNumber2 = reverseRecursion(number);
		System.out.println(reverseNumber1);	//without recursion
		System.out.println(reverseNumber2); //with recursion

		String s = "abc";
		String sReverse = reverseString(s);
		System.out.println(sReverse);
	}

	private static String reverseString(String s) {
		StringBuffer b = new StringBuffer(s);
		StringBuffer c = b.reverse();
		return c.toString();
	}

	private static int reverse(int n) {
		if(n == 0) return 0;
		int i = 0;
		while(n>0){
			i=i*10+(n%10);
			n=n/10;
		}
		return i;
	}

	public static int rev=0;
	private static int reverseRecursion(int num)
	{
		if (num < 10) {
			rev = rev*10 + num;
		}
		else {
			rev = rev*10 + (num % 10);
			reverseRecursion(num / 10);
		}
		return rev;
	}
}
