package Concepts.interfaceDemo;

interface demoInterface {
	String a = "hello";
}

class demo implements demoInterface{
	
}

public class abc{
	public static void main(String[] args) {
		System.out.println(demo.a);
		System.out.println(demoInterface.a);
		//demo.a = "world";  //Not possible as 'a' is final in interface
	}
}
