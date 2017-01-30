package concepts;

public class Typecasting {
	public static void main(String[] args) {
		String a = "abc";
		Object b = (Object) a;

		System.out.println(a.equals(b));
		System.out.println(b.equals(a));

		System.out.println(a == b);

		try{
			System.out.println("try");
			A aa = new A();
			aa.getABC();
		} finally{
			System.out.println("finally");
		}
	}
}

class A{
	int  getABC(){
		return 0/0;
	}
}
