package concepts;

public class MethodCallingThroughtSpecificArguments {
public static void main(String[] args) {
	callm("abc");
	callm(new Long(3));
	//callm(null);  
					/*
					 compilation error---When both the String and Integer versions are available, 
					 then both of them are more specific than Object but none is more specific than the other.
					 
					 If String and Object versions are available the control will go to String one 
					 as it is more specific.
					*/
}

private static void callm(String string) {
	System.out.println("string");
	
}
private static void callm(Object string) {
	System.out.println("object");
	
}
@SuppressWarnings("unused")
private static void callm(Integer string) {
	System.out.println("integer");
	
}
}
